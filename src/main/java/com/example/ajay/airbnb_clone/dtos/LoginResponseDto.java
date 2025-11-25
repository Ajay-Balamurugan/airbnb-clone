package com.example.ajay.airbnb_clone.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    private String token;
    private String tokenType;
    private Date expiresIn; // expiration time in milliseconds
}