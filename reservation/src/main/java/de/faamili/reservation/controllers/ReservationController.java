package de.faamili.reservation.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.faamili.reservation.dtos.ReservationDto;
import de.faamili.reservation.dtos.UserDto;
import de.faamili.reservation.services.UserService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final UserService userService;

    @GetMapping()
    public List<ReservationDto> getAllReservations() {
        ReservationDto reservation1 = new ReservationDto("1", "John Doe", java.time.LocalDate.of(2023, 10, 1),
                java.time.LocalDate.of(2023, 10, 5));
        ReservationDto reservation2 = new ReservationDto("2", "Jane Smith", java.time.LocalDate.of(2023, 11, 10),
                java.time.LocalDate.of(2023, 11, 15));
        return List.of(reservation1, reservation2);
    }

    @GetMapping("/{id}")
    public ReservationDto getReservationById(@PathVariable String id) {

        // perform a rest call to fetch the user details
        UserDto user = userService.getUserById("user123"); // Example user ID
        String customerName = user.getName();

        return new ReservationDto(id, customerName, java.time.LocalDate.of(2023, 10, 1),
                java.time.LocalDate.of(2023, 10, 5));
    }
}
