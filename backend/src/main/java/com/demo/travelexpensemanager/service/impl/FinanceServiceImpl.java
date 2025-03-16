package com.demo.travelexpensemanager.service.impl;

import com.demo.travelexpensemanager.dto.request.RefundStatusRequest;
import com.demo.travelexpensemanager.dto.response.TripResponse;
import com.demo.travelexpensemanager.model.RefundStatus;
import com.demo.travelexpensemanager.model.Trip;
import com.demo.travelexpensemanager.model.User;
import com.demo.travelexpensemanager.model.enums.RoleType;
import com.demo.travelexpensemanager.model.enums.TripStatus;
import com.demo.travelexpensemanager.repository.RefundStatusRepository;
import com.demo.travelexpensemanager.repository.TripRepository;
import com.demo.travelexpensemanager.exception.ResourceNotFoundException;
import com.demo.travelexpensemanager.exception.UnauthorizedException;
import com.demo.travelexpensemanager.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private RefundStatusRepository refundStatusRepository;

    @Autowired
    private TripServiceImpl tripService;

    @Override
    public List<TripResponse> getApprovedTrips(User currentUser) {
        validateFinanceRole(currentUser);

        List<Trip> approvedTrips = tripRepository.findByStatus(TripStatus.APPROVED);

        return approvedTrips.stream()
                .map(trip -> tripService.convertToTripResponse(trip))
                .collect(Collectors.toList());
    }

    @Override
    public TripResponse getTripById(Long tripId, User currentUser) {
        validateFinanceRole(currentUser);

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found with id: " + tripId));

        if (trip.getStatus() != TripStatus.APPROVED) {
            throw new IllegalStateException("Finance users can only view approved trips");
        }

        return tripService.convertToTripResponse(trip);
    }

    @Override
    @Transactional
    public TripResponse updateRefundStatus(Long tripId, RefundStatusRequest request, User currentUser) {
        validateFinanceRole(currentUser);

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found with id: " + tripId));

        if (trip.getStatus() != TripStatus.APPROVED) {
            throw new IllegalStateException("Refund status can only be updated for approved trips");
        }

        RefundStatus refundStatus = refundStatusRepository.findByTrip(trip)
                .orElseThrow(() -> new ResourceNotFoundException("Refund status not found for trip: " + tripId));

        refundStatus.setStatus(request.getStatus());
        refundStatus.setUpdatedAt(LocalDateTime.now());
        refundStatus.setFinanceUser(currentUser);

        refundStatusRepository.save(refundStatus);

        return tripService.convertToTripResponse(trip);
    }

    @Override
    public List<TripResponse> generateReport(LocalDate startDate, LocalDate endDate, User currentUser) {
        validateFinanceRole(currentUser);
        
        // Find trips that have a start date and end date within the requested period
        List<Trip> tripsInDateRange = tripRepository.findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndStatus(
                startDate, 
                endDate,
                TripStatus.APPROVED);
        
        return tripsInDateRange.stream()
                .map(trip -> tripService.convertToTripResponse(trip))
                .collect(Collectors.toList());
    }

    private void validateFinanceRole(User user) {
        boolean isFinance = user.getRoles().stream()
                .anyMatch(role -> role.getName() == RoleType.ROLE_FINANCE);

        if (!isFinance) {
            throw new UnauthorizedException("You don't have finance permissions");
        }
    }
}