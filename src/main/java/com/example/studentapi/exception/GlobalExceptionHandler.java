package com.example.studentapi.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.studentapi.util.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //* 1. Not Found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(404)
                .body(new ApiResponse("error", ex.getMessage(), null));
    }

    //* 2. Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidation(MethodArgumentNotValidException ex) {

        String error = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return ResponseEntity.badRequest()
                .body(new ApiResponse("error", error, null));
    }

    //* 3. Duplicate / DB constraint errors (IMPORTANT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> handleDuplicate(DataIntegrityViolationException ex) {

        String message = "Database error";

        if (ex.getMessage().contains("subject_code")) {
            message = "subjectCode already exists";
        }

        return ResponseEntity.badRequest()
                .body(new ApiResponse("error", message, null));
    }

    //* 4. Catch all errors (fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGeneric(Exception ex) {

        ex.printStackTrace(); // *  keep this for debugging

        return ResponseEntity.status(500)
                .body(new ApiResponse("error", "Something went wrong", null));
    }
}