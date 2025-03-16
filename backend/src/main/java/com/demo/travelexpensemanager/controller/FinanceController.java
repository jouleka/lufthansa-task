package com.demo.travelexpensemanager.controller;

import com.demo.travelexpensemanager.dto.request.RefundStatusRequest;
import com.demo.travelexpensemanager.dto.response.TripResponse;
import com.demo.travelexpensemanager.model.User;
import com.demo.travelexpensemanager.repository.UserRepository;
import com.demo.travelexpensemanager.security.services.UserDetailsImpl;
import com.demo.travelexpensemanager.service.FinanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/approved-trips")
    @PreAuthorize("hasRole('FINANCE')")
    public ResponseEntity<List<TripResponse>> getApprovedTrips() {
        User currentUser = getCurrentUser();
        List<TripResponse> response = financeService.getApprovedTrips(currentUser);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/trips/{tripId}")
    @PreAuthorize("hasRole('FINANCE')")
    public ResponseEntity<TripResponse> getTripById(@PathVariable Long tripId) {
        User currentUser = getCurrentUser();
        TripResponse response = financeService.getTripById(tripId, currentUser);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/trips/{tripId}/refund-status")
    @PreAuthorize("hasRole('FINANCE')")
    public ResponseEntity<TripResponse> updateRefundStatus(@PathVariable Long tripId, @Valid @RequestBody RefundStatusRequest request) {
        User currentUser = getCurrentUser();
        TripResponse response = financeService.updateRefundStatus(tripId, request, currentUser);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/reports")
    @PreAuthorize("hasRole('FINANCE')")
    public ResponseEntity<?> generateReport(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        
        User currentUser = getCurrentUser();
        List<TripResponse> trips = financeService.generateReport(startDate, endDate, currentUser);
        
        Map<String, Object> response = new HashMap<>();
        response.put("trips", trips);
        response.put("startDate", startDate.toString());
        response.put("endDate", endDate.toString());
        
        return ResponseEntity.ok(response);
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userRepository.findById(userDetails.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
