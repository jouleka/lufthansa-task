package com.demo.travelexpensemanager.dto.response;

import com.demo.travelexpensemanager.model.enums.RefundStatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundStatusResponse {
    private Long id;
    private RefundStatusType status;
    private LocalDateTime updatedAt;
    private UserResponse financeUser;
}
