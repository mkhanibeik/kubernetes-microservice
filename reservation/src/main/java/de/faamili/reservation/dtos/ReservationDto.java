package de.faamili.reservation.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReservationDto {
    private String id;
    private String customerName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
