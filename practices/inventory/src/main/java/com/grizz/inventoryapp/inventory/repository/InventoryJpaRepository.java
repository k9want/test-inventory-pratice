package com.grizz.inventoryapp.inventory.repository;

import com.grizz.inventoryapp.inventory.repository.entity.InventoryEntity;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public interface InventoryJpaRepository {

    @NotNull Optional<InventoryEntity> findByItemId(@NotNull String itemId);
}
