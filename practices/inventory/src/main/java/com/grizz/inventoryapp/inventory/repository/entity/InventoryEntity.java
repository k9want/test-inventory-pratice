package com.grizz.inventoryapp.inventory.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Table(name = "inventory")
@Entity
public class InventoryEntity {

    @Id
    private @Nullable Long id; // id가 Null일 수 있는 건 id가 Null일 때 JPA가 알아서 채워주는 패턴 때문에
    private @NotNull String itemId;
    private @NotNull Long stock;

    public InventoryEntity(@Nullable Long id, @NotNull String itemId, @NotNull Long stock) {
        this.id = id;
        this.itemId = itemId;
        this.stock = stock;
    }

    public InventoryEntity() {

    }

    public @NotNull String getItemId() {
        return itemId;
    }

    public Long getStock() {
        return stock;
    }

    public Long getId() {
        return id;
    }

    public void setStock(@NotNull Long stock) {
        this.stock = stock;
    }
}
