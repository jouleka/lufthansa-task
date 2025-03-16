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
@Table(name = "taxi")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Taxi extends Expense {
    @NotBlank
    private String fromLocation;

    @NotBlank
    private String toLocation;

    @NotNull
    private LocalDateTime time;

    public Taxi(String fromLocation, String toLocation, LocalDateTime time, Double totalPrice) {
        super();
        this.setType(ExpenseType.TAXI);
        this.setTotalPrice(totalPrice);
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.time = time;
    }
}
