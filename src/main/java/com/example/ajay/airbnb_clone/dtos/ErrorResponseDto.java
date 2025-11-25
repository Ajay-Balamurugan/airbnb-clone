package com.example.ajay.airbnb_clone.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class ErrorResponseDto {
    private String message;
    private Date timestamp;
    private String status;

    public ErrorResponseDto(String message, String status) {
        this.message = message;
        this.timestamp = new Date(System.currentTimeMillis());
        this.status = status;
    }
}