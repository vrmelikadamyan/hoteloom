package com.vmelik.hotel.controller;

import com.vmelik.hotel.exception.HotelNotFoundException;
import com.vmelik.hotel.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(HotelNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }
}
