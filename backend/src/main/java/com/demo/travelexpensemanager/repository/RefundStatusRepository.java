package com.demo.travelexpensemanager.repository;

import com.demo.travelexpensemanager.model.RefundStatus;
import com.demo.travelexpensemanager.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RefundStatusRepository extends JpaRepository<RefundStatus, Long> {
    Optional<RefundStatus> findByTrip(Trip trip);
    List<RefundStatus> findByStatus(RefundStatus status);
}
