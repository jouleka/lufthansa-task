package com.demo.travelexpensemanager.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaxiRequest {
    @NotBlank
    private String fromLocation;

    @NotBlank
    private String toLocation;

    @NotNull
    private LocalDateTime time;

    @NotNull
    private Double totalPrice;
}
