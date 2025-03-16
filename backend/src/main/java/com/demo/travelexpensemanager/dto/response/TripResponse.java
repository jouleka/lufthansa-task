package com.demo.travelexpensemanager.dto.response;

import com.demo.travelexpensemanager.model.enums.TripStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripResponse {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private TripStatus status;
    private UserResponse user;
    private List<ExpenseResponse> expenses;
    private List<ApprovalNoteResponse> approvalNotes;
    private RefundStatusResponse refundStatus;
    private Double totalExpenses;
}
