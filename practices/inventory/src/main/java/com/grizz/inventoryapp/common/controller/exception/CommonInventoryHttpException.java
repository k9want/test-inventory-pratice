package com.grizz.inventoryapp.common.controller.exception;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;

public class CommonInventoryHttpException extends RuntimeException{

    private @NotNull final String localMessage;
    private @NotNull final Long code;
    private @NotNull final HttpStatus status;


    public CommonInventoryHttpException(@NotNull String localMessage, @NotNull Long code,
        @NotNull HttpStatus status) {
        this.localMessage = localMessage;
        this.code = code;
        this.status = status;
    }

    public @NotNull String getLocalMessage() {
        return localMessage;
    }

    public @NotNull Long getCode() {
        return code;
    }

    public @NotNull HttpStatus getStatus() {
        return status;
    }
}
