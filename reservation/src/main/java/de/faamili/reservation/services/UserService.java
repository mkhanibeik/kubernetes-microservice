package de.faamili.reservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import de.faamili.reservation.dtos.UserDto;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final RestTemplate restTemplate;

    @Value("${user.service.url:http://userservice:8080}")
    private String userServiceUrl;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Fetches user details by user ID from external user service
     * 
     * @param userId the ID of the user to fetch
     * @return UserDto containing user details
     * @throws RestClientException if the REST call fails
     */
    public UserDto getUserById(String userId) {
        try {
            String url = userServiceUrl + "/users/" + userId;
            UserDto user = restTemplate.getForObject(url, UserDto.class);

            if (user == null) {
                // Return a default user if service returns null
                return new UserDto(userId, "Unknown User", "unknown@example.com");
            }

            return user;
        } catch (RestClientException e) {
            // Log the error and return a default user
            logger.error("Failed to fetch user with ID: {}. Error: {}", userId, e.getMessage());
            return new UserDto(userId, "Unknown User", "unknown@example.com");
        }
    }
}