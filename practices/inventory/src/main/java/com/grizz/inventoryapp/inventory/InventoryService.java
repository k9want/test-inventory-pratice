package com.grizz.inventoryapp.inventory;

import com.grizz.inventoryapp.inventory.repository.InventoryJpaRepository;
import com.grizz.inventoryapp.inventory.repository.entity.InventoryEntity;
import com.grizz.inventoryapp.inventory.service.domain.Inventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InventoryService {
    private final InventoryJpaRepository inventoryJpaRepository;

    public InventoryService(InventoryJpaRepository inventoryJpaRepository) {
        this.inventoryJpaRepository = inventoryJpaRepository;
    }

    public @Nullable Inventory findByItemId(@NotNull String itemId) {
        return inventoryJpaRepository.findByItemId(
            itemId).map(this::mapToDomain)
            .orElse(null);
    }

    public @NotNull Inventory descreasByItemId(@NotNull String itemId, @NotNull Long quantity) {
        return null;
    }

    private Inventory mapToDomain(InventoryEntity entity) {
        return new Inventory(entity.getItemId(), entity.getStock());
    }
}
