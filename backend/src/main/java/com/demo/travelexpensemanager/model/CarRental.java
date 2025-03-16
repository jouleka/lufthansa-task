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
@Table(name = "car_rental")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CarRental extends Expense {
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

    public CarRental(String carName, LocalDateTime pickupTime, LocalDateTime dropTime,
                     String pickupLocation, String dropLocation, Double totalPrice) {
        super();
        this.setType(ExpenseType.CAR_RENTAL);
        this.setTotalPrice(totalPrice);
        this.carName = carName;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
    }
}
