package com.demo.travelexpensemanager.dto.request;

import com.demo.travelexpensemanager.model.enums.RefundStatusType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RefundStatusRequest {
    @NotNull
    private RefundStatusType status;
}
