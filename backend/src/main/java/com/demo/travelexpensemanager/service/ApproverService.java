package com.demo.travelexpensemanager.service;

import com.demo.travelexpensemanager.dto.request.ApprovalRequest;
import com.demo.travelexpensemanager.dto.response.TripResponse;
import com.demo.travelexpensemanager.model.User;

import java.util.List;

public interface ApproverService {
    List<TripResponse> getPendingTrips(User currentUser);
    TripResponse getTripForApproval(Long tripId, User currentUser);
    TripResponse approveTrip(Long tripId, ApprovalRequest request, User currentUser);
    TripResponse rejectTrip(Long tripId, ApprovalRequest request, User currentUser);
}