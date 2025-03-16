package com.demo.travelexpensemanager.service;

import com.demo.travelexpensemanager.dto.request.CarRentalRequest;
import com.demo.travelexpensemanager.dto.request.FlightRequest;
import com.demo.travelexpensemanager.dto.request.HotelRequest;
import com.demo.travelexpensemanager.dto.request.TaxiRequest;
import com.demo.travelexpensemanager.dto.response.ExpenseResponse;
import com.demo.travelexpensemanager.model.User;

public interface ExpenseService {
    ExpenseResponse addCarRental(Long tripId, CarRentalRequest request, User currentUser);
    ExpenseResponse addHotel(Long tripId, HotelRequest request, User currentUser);
    ExpenseResponse addFlight(Long tripId, FlightRequest request, User currentUser);
    ExpenseResponse addTaxi(Long tripId, TaxiRequest request, User currentUser);
    ExpenseResponse getExpenseById(Long id, User currentUser);
    ExpenseResponse updateCarRental(Long id, CarRentalRequest request, User currentUser);
    ExpenseResponse updateHotel(Long id, HotelRequest request, User currentUser);
    ExpenseResponse updateFlight(Long id, FlightRequest request, User currentUser);
    ExpenseResponse updateTaxi(Long id, TaxiRequest request, User currentUser);
    void deleteExpense(Long id, User currentUser);
}
