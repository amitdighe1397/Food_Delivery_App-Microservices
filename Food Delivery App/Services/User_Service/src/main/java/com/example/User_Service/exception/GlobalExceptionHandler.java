package com.example.User_Service.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    // Handle custom exceptions for not found entities (e.g., UserNotFound, OrderNotFound, etc.)
    @ExceptionHandler({UserNotFoundException.class,
            RestaurantNotFoundException.class,
            OrderNotFoundException.class,
            DeliveryNotFoundException.class,
            PaymentNotFoundException.class,
            DeliveryAgentNotFoundException.class})
    public ResponseEntity<Map<String, String>> handleNotFoundException(RuntimeException ex) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("error", ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // Handle invalid input (e.g., invalid request parameters or missing fields)
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("error", ex.getMessage());
        return errorDetails;
    }

    // Handle general exception cases
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleGeneralException(Exception ex) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("error", "Internal server error: " + ex.getMessage());
        return errorDetails;
    }

    // Handle validation exception (e.g., validation failures in request bodies)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("error", "Validation failed: " + ex.getMessage());
        return errorDetails;
    }
}
