package de.faamili.user.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.faamili.user.dtos.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<UserDto> getAllUsers() {
        UserDto user1 = new UserDto("1", "John Doe", "john.doe@example.com");
        UserDto user2 = new UserDto("2", "Jane Smith", "jane.smith@example.com");
        return List.of(user1, user2);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id) {
        return new UserDto(id, "John Doe", "john.doe@example.com");
    }
}
