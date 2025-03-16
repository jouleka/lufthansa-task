package com.demo.travelexpensemanager.model;

import com.demo.travelexpensemanager.model.enums.RefundStatusType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "refund_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefundStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RefundStatusType status = RefundStatusType.PENDING;

    @NotNull
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finance_user_id", nullable = true)
    private User financeUser;
}
