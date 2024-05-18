package com.grizz.inventoryapp.common.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.jetbrains.annotations.Nullable;

@JsonInclude(Include.NON_NULL)
public record ApiResponse<T>(
    @Nullable T data,
    @Nullable ApiErrorResponse error
) {

}

