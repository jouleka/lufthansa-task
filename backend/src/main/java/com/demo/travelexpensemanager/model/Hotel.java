package com.demo.travelexpensemanager.model;

import com.demo.travelexpensemanager.model.enums.ExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "hotel")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Hotel extends Expense {
    @NotBlank
    private String hotelName;

    @NotBlank
    private String location;

    @NotNull
    private LocalDate checkInDate;

    @NotNull
    private LocalDate checkOutDate;

    public Hotel(String hotelName, String location, LocalDate checkInDate,
                 LocalDate checkOutDate, Double totalPrice) {
        super();
        this.setType(ExpenseType.HOTEL);
        this.setTotalPrice(totalPrice);
        this.hotelName = hotelName;
        this.location = location;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
}
