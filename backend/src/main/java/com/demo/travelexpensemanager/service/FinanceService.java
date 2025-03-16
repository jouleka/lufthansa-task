package com.demo.travelexpensemanager.service;

import com.demo.travelexpensemanager.dto.request.RefundStatusRequest;
import com.demo.travelexpensemanager.dto.response.TripResponse;
import com.demo.travelexpensemanager.model.User;

import java.time.LocalDate;
import java.util.List;

public interface FinanceService {
    List<TripResponse> getApprovedTrips(User currentUser);
    TripResponse getTripById(Long tripId, User currentUser);
    TripResponse updateRefundStatus(Long tripId, RefundStatusRequest request, User currentUser);
    List<TripResponse> generateReport(LocalDate startDate, LocalDate endDate, User currentUser);
}
