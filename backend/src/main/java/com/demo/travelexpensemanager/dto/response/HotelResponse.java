package com.demo.travelexpensemanager.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class HotelResponse extends ExpenseResponse {
    private String hotelName;
    private String location;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
