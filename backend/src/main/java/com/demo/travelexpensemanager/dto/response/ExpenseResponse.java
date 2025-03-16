package com.demo.travelexpensemanager.dto.response;

import com.demo.travelexpensemanager.model.enums.ExpenseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponse {
    private Long id;
    private ExpenseType type;
    private Double totalPrice;
    private LocalDateTime createdAt;

    private String details;
}
