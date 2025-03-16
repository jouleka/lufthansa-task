package com.demo.travelexpensemanager.repository;

import com.demo.travelexpensemanager.model.ApprovalNote;
import com.demo.travelexpensemanager.model.Trip;
import com.demo.travelexpensemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovalNoteRepository extends JpaRepository<ApprovalNote, Long> {
    List<ApprovalNote> findByTrip(Trip trip);
    List<ApprovalNote> findByApprover(User approver);
}
