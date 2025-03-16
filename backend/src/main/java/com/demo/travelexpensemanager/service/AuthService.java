package com.demo.travelexpensemanager.service;

import com.demo.travelexpensemanager.dto.request.LoginRequest;
import com.demo.travelexpensemanager.dto.request.SignupRequest;
import com.demo.travelexpensemanager.dto.response.JwtResponse;
import com.demo.travelexpensemanager.dto.response.MessageResponse;

public interface AuthService {
    JwtResponse authenticateUser(LoginRequest loginRequest);
    MessageResponse registerUser(SignupRequest signupRequest);
}
