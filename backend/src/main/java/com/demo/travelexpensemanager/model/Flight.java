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

import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Flight extends Expense {
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

    public Flight(String airline, String departureLocation, String arrivalLocation,
                  LocalDateTime departureTime, LocalDateTime arrivalTime, Double totalPrice) {
        super();
        this.setType(ExpenseType.FLIGHT);
        this.setTotalPrice(totalPrice);
        this.airline = airline;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
}
