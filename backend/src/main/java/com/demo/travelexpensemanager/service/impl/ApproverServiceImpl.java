package com.demo.travelexpensemanager.service.impl;

import com.demo.travelexpensemanager.dto.request.ApprovalRequest;
import com.demo.travelexpensemanager.dto.response.TripResponse;
import com.demo.travelexpensemanager.exception.ResourceNotFoundException;
import com.demo.travelexpensemanager.exception.UnauthorizedException;
import com.demo.travelexpensemanager.model.ApprovalNote;
import com.demo.travelexpensemanager.model.RefundStatus;
import com.demo.travelexpensemanager.model.Trip;
import com.demo.travelexpensemanager.model.User;
import com.demo.travelexpensemanager.model.enums.RefundStatusType;
import com.demo.travelexpensemanager.model.enums.RoleType;
import com.demo.travelexpensemanager.model.enums.TripStatus;
import com.demo.travelexpensemanager.repository.ApprovalNoteRepository;
import com.demo.travelexpensemanager.repository.RefundStatusRepository;
import com.demo.travelexpensemanager.repository.TripRepository;
import com.demo.travelexpensemanager.service.ApproverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApproverServiceImpl implements ApproverService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private ApprovalNoteRepository approvalNoteRepository;

    @Autowired
    private RefundStatusRepository refundStatusRepository;

    @Autowired
    private TripServiceImpl tripService;

    @Override
    public List<TripResponse> getPendingTrips(User currentUser) {
        validateApproverRole(currentUser);

        List<Trip> pendingTrips = tripRepository.findByStatus(TripStatus.PENDING_APPROVAL);

        return pendingTrips.stream()
                .map(trip -> tripService.convertToTripResponse(trip))
                .collect(Collectors.toList());
    }

    @Override
    public TripResponse getTripForApproval(Long tripId, User currentUser) {
        validateApproverRole(currentUser);

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found with id: " + tripId));

        return tripService.convertToTripResponse(trip);
    }

    @Override
    @Transactional
    public TripResponse approveTrip(Long tripId, ApprovalRequest request, User currentUser) {
        validateApproverRole(currentUser);

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found with id: " + tripId));

        if (trip.getStatus() != TripStatus.PENDING_APPROVAL) {
            throw new IllegalStateException("Trip is not in pending approval status");
        }

        // Create the approval note
        ApprovalNote note = new ApprovalNote();
        note.setNote(request.getNote());
        note.setTrip(trip);
        note.setApprover(currentUser);
        approvalNoteRepository.save(note);

        // Set status to APPROVED for approval
        trip.setStatus(TripStatus.APPROVED);
        Trip updatedTrip = tripRepository.save(trip);
        
        // Create refund status - if this fails, it will throw an exception and rollback the entire transaction
        RefundStatus refundStatus = new RefundStatus();
        refundStatus.setTrip(updatedTrip);
        refundStatus.setStatus(RefundStatusType.PENDING);
        refundStatusRepository.save(refundStatus);

        return tripService.convertToTripResponse(updatedTrip);
    }

    @Override
    @Transactional
    public TripResponse rejectTrip(Long tripId, ApprovalRequest request, User currentUser) {
        validateApproverRole(currentUser);

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found with id: " + tripId));

        if (trip.getStatus() != TripStatus.PENDING_APPROVAL) {
            throw new IllegalStateException("Trip is not in pending approval status");
        }

        ApprovalNote note = new ApprovalNote();
        note.setNote(request.getNote());
        note.setTrip(trip);
        note.setApprover(currentUser);
        approvalNoteRepository.save(note);

        // Set status to REJECTED for rejection
        trip.setStatus(TripStatus.REJECTED);
        Trip updatedTrip = tripRepository.save(trip);

        return tripService.convertToTripResponse(updatedTrip);
    }

    private void validateApproverRole(User user) {
        boolean isApprover = user.getRoles().stream()
                .anyMatch(role -> role.getName() == RoleType.ROLE_APPROVER);

        if (!isApprover) {
            throw new UnauthorizedException("You don't have approver permissions");
        }
    }
}
