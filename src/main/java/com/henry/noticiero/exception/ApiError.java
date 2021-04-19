package com.henry.noticiero.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiError(HttpStatus badRequest, String localizedMessage, List<String> errors) {
    }

    public HttpStatus getStatus() {
    return status;
    }
}
