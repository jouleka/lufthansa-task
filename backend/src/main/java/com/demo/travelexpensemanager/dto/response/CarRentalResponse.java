package com.demo.travelexpensemanager.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CarRentalResponse extends ExpenseResponse {
    private String carName;
    private LocalDateTime pickupTime;
    private LocalDateTime dropTime;
    private String pickupLocation;
    private String dropLocation;
}
