package com.grizz.inventoryapp.inventory.repository;

import com.grizz.inventoryapp.inventory.repository.entity.InventoryEntity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InventoryJpaRepositoryStub implements InventoryJpaRepository {
    private final List<InventoryEntity> inventoryEntities = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public void addInventoryEntity(String itemId, Long stock) {
        final Long id = idGenerator.getAndIncrement();
        final InventoryEntity inventoryEntity = new InventoryEntity(id, itemId, stock);
        inventoryEntities.add(inventoryEntity);
    }

    @Override
    public @NotNull Optional<InventoryEntity> findByItemId(@NotNull String itemId) {
        return inventoryEntities.stream()
                .filter(inventoryEntity -> inventoryEntity.getItemId().equals(itemId))
                .findFirst();
    }
}
