package com.demo.travelexpensemanager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalNoteResponse {
    private Long id;
    private String note;
    private LocalDateTime createdAt;
    private UserResponse approver;
}
