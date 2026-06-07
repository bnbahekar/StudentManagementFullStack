package com.example.studentapi.util;

public class ApiResponse {

    private String status;
    private String message;
    private Object data;

    public ApiResponse(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    //* REQUIRED for JSON serialization
    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}