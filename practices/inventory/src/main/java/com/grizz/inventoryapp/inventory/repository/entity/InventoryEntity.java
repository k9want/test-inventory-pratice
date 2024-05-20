package com.grizz.inventoryapp.inventory.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Table(name = "inventory")
@Entity
public class InventoryEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private @Nullable Long id; // id가 Null일 수 있는 건 id가 Null일 때 JPA가 알아서 채워주는 패턴 때문에
    private @NotNull String itemId;
    private @NotNull Long stock;

    @CreatedDate
    private @Nullable ZonedDateTime createdAt;
    @LastModifiedDate
    private @Nullable ZonedDateTime updatedAt;


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

    public @NotNull Long getStock() {
        return stock;
    }

    public Long getId() {
        return id;
    }

    public @Nullable ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public @Nullable ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }


    public void setStock(@NotNull Long stock) {
        this.stock = stock;
    }
}
