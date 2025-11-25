package com.example.ajay.airbnb_clone.controllers;

import com.example.ajay.airbnb_clone.dtos.AuthRequestDto;
import com.example.ajay.airbnb_clone.dtos.LoginResponseDto;
import com.example.ajay.airbnb_clone.util.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTUtility jwtUtility;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody AuthRequestDto authRequest) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        authenticationManager.authenticate(auth);

        String token = jwtUtility.generateToken(authRequest.getUsername());
        Date expirationTime = jwtUtility.getExpirationTime(token);
        LoginResponseDto response = new LoginResponseDto(token, "Bearer", expirationTime);
        
        return ResponseEntity.ok(response);
    }
}
