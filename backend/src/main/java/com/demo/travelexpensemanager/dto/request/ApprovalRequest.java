package com.demo.travelexpensemanager.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ApprovalRequest {
    @NotBlank
    private String note;

    @NotNull
    private Boolean approved;
}
