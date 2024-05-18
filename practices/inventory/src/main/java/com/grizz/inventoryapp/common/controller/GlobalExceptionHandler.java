package com.grizz.inventoryapp.common.controller;

import com.grizz.inventoryapp.common.controller.exception.CommonInventoryHttpException;
import java.nio.charset.StandardCharsets;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {CommonInventoryHttpException.class})
    public ResponseEntity<ApiResponse<Void>> handleCommonInventoryHttpException(
        CommonInventoryHttpException exception
    ) {
        final ApiResponse<Void> body = ApiResponse.fromErrorCodes(
            exception.getErrorCodes()
        );
        final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8);
        final HttpStatus status = exception.getStatus();

        return ResponseEntity.status(status)
            .contentType(contentType)
            .body(body);
    }

}
