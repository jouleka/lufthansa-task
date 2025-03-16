package com.demo.travelexpensemanager.service;

import com.demo.travelexpensemanager.dto.request.TripRequest;
import com.demo.travelexpensemanager.dto.response.TripResponse;
import com.demo.travelexpensemanager.model.Trip;
import com.demo.travelexpensemanager.model.User;

import java.util.List;

public interface TripService {
    TripResponse createTrip(TripRequest tripRequest, User currentUser);
    TripResponse getTripById(Long id, User currentUser);
    List<TripResponse> getTripsByUser(User currentUser);
    TripResponse updateTrip(Long id, TripRequest tripRequest, User currentUser);
    void deleteTrip(Long id, User currentUser);
    TripResponse submitTripForApproval(Long id, User currentUser);
    Trip findTripEntityById(Long id);
}
