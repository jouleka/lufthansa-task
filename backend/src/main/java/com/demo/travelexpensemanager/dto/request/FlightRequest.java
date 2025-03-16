package com.demo.travelexpensemanager.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightRequest {
    @NotBlank
    private String airline;

    @NotBlank
    private String departureLocation;

    @NotBlank
    private String arrivalLocation;

    @NotNull
    private LocalDateTime departureTime;

    @NotNull
    private LocalDateTime arrivalTime;

    @NotNull
    private Double totalPrice;
}
