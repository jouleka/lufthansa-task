package com.demo.travelexpensemanager.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarRentalRequest {
    @NotBlank
    private String carName;

    @NotNull
    private LocalDateTime pickupTime;

    @NotNull
    private LocalDateTime dropTime;

    @NotBlank
    private String pickupLocation;

    @NotBlank
    private String dropLocation;

    @NotNull
    private Double totalPrice;
}
