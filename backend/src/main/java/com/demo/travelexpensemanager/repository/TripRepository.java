package com.demo.travelexpensemanager.repository;

import com.demo.travelexpensemanager.model.Trip;
import com.demo.travelexpensemanager.model.User;
import com.demo.travelexpensemanager.model.enums.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByUser(User user);
    List<Trip> findByStatus(TripStatus status);
    List<Trip> findByUserAndStatus(User user, TripStatus status);
    List<Trip> findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndStatus(LocalDate startDate, LocalDate endDate, TripStatus status);
}
