package com.demo.travelexpensemanager.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TaxiResponse extends ExpenseResponse {
    private String fromLocation;
    private String toLocation;
    private LocalDateTime time;
}
