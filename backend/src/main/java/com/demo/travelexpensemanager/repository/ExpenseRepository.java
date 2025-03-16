package com.demo.travelexpensemanager.repository;

import com.demo.travelexpensemanager.model.Expense;
import com.demo.travelexpensemanager.model.Trip;
import com.demo.travelexpensemanager.model.enums.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByTrip(Trip trip);
    List<Expense> findByTripAndType(Trip trip, ExpenseType type);
}
