package com.demo.travelexpensemanager.model;

import com.demo.travelexpensemanager.model.enums.TripStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private TripStatus status = TripStatus.DRAFT;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expense> expenses = new ArrayList<>();

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApprovalNote> approvalNotes = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
        expense.setTrip(this);
    }

    public void removeExpense(Expense expense) {
        expenses.remove(expense);
        expense.setTrip(null);
    }

    public Double calculateTotalExpenses() {
        return expenses.stream()
                .mapToDouble(Expense::getTotalPrice)
                .sum();
    }
}
