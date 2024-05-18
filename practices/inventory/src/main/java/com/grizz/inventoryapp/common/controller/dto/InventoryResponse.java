package com.grizz.inventoryapp.common.controller.dto;

import org.jetbrains.annotations.NotNull;

public record InventoryResponse(
    @NotNull String itemId,
    @NotNull Long stock
) {

}
