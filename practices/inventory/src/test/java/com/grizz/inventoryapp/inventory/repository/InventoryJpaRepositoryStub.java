package com.grizz.inventoryapp.inventory.repository;

import com.grizz.inventoryapp.inventory.repository.entity.InventoryEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.NotNull;

public class InventoryJpaRepositoryStub implements InventoryJpaRepository {
    // db 연결 x -> in memory를 통해 (stub)
    private final List<InventoryEntity> inventoryEntities = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public void addInventoryEntity(@NotNull String itemId, @NotNull Long stock) {
        final Long id = idGenerator.getAndIncrement();
        inventoryEntities.add(new InventoryEntity(id, itemId, stock));
    }

    @Override
    public @NotNull Optional<InventoryEntity> findByItemId(@NotNull String itemId) {
        return inventoryEntities.stream()
            .filter(entity -> entity.getItemId().equals(itemId))
            .findFirst();
    }
}
