package com.grizz.inventoryapp.common.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grizz.inventoryapp.inventory.controller.consts.ErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonInclude(Include.NON_NULL)
public record ApiResponse<T>(
    @Nullable T data,
    @Nullable ApiErrorResponse error
) {

    public static <T> ApiResponse<T> just(T data) {
        return new ApiResponse<>(data, null);
    }

    public static <T> ApiResponse<T> fromErrorCodes(@NotNull ErrorCodes errorCodes) {
        final ApiErrorResponse errorResponse = new ApiErrorResponse(errorCodes.message, errorCodes.code);
        return new ApiResponse<>(null, errorResponse);
    }
}

