package com.grizz.inventoryapp.inventory.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.grizz.inventoryapp.config.JpaConfig;
import com.grizz.inventoryapp.inventory.repository.entity.InventoryEntity;
import java.time.ZonedDateTime;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@Import(JpaConfig.class)
@ActiveProfiles("h2-test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class InventoryJpaRepositoryTest {

    @Autowired
    InventoryJpaRepository sut; // system under test 테스트 대상

    @Autowired
    TestEntityManager entityManager;

    @Nested
    class FindByItemId { // query method

        final String existingItemId = "1";
        final String nonExistingItemId = "2";
        final Long stock = 100L;
        @DisplayName("itemId를 갖는 entity가 없다면 empty를 반환한다.")
        @Test
        void test1() {
            //when
            Optional<InventoryEntity> result = sut.findByItemId(nonExistingItemId);

            //then
            assertTrue(result.isEmpty());
            
        }

        @DisplayName("itemId를 갖는 entity가 있다면, entity를 반환한다.")
        @Test
        void test2() {
            //when
            Optional<InventoryEntity> result = sut.findByItemId(existingItemId);

            //then
            assertTrue(result.isPresent());

            final InventoryEntity entity = result.get();
            assertNotNull(entity.getId());
            assertEquals(existingItemId, entity.getItemId());
            assertEquals(stock, entity.getStock());

        }

    }

    @Nested
    class DecreaseStock { // query annotation
        final String existingItemId = "1";
        final String nonExistingItemId = "2";
        @DisplayName("itemId를 갖는 entity가 없다면 0을 반환한다.")
        @Test
        void test1() {
            //given
            final Long quantity = 10L;

            //when
            final Integer result = sut.decreaseStock(nonExistingItemId, quantity);

            //then
            assertEquals(0, result);

        }

        @Test
        @DisplayName("itemId를 갖는 entity가 있다면, stock을 차감하고 1을 반환한다.")
        void test2() {
            //given
            final ZonedDateTime lastUpdatedAt = sut.findByItemId(existingItemId).get().getUpdatedAt();

            //when
            final Integer result = sut.decreaseStock(existingItemId, 10L);
            entityManager.clear();

            //then
            assertEquals(1, result);

            final InventoryEntity entity = sut.findByItemId(existingItemId).get();
            assertNotEquals(lastUpdatedAt, entity.getUpdatedAt());

        }
    }

    @Nested
    class Save { // 기본

        final Long existingId = 1L;
        final String existingItemId = "1";
        final String nonExistingItemId = "2";
        @DisplayName("id를 갖는 entity가 없다면, entity를 추가하고 추가된 entity를 반환한다.")
        @Test
        void test1() {
            // given
            final Long newStock = 1234L;
            //when
            final InventoryEntity entity = new InventoryEntity(null, nonExistingItemId, newStock);
            final InventoryEntity result = sut.save(entity);

            //then
            assertNotNull(result.getId());
            assertEquals(nonExistingItemId, result.getItemId());
            assertEquals(newStock, result.getStock());

            assertNotNull(result.getCreatedAt());
            assertNotNull(result.getCreatedAt());
        }

        @DisplayName("id를 갖는 entity가 있다면, entity를 수정하고 수정된 entity를 반환한다.")
        @Test
        void test2() {
            //given
            final Long newStock = 1234L;
            final InventoryEntity entity = sut.findByItemId(existingItemId).get();
            final ZonedDateTime lastCreatedAt = entity.getCreatedAt();
            final ZonedDateTime lastUpdatedAt = entity.getUpdatedAt();

            //when
            entity.setStock(newStock);
            final InventoryEntity result = sut.save(entity);
            entityManager.flush();

            //then
            assertEquals(existingId, result.getId());
            assertEquals(existingItemId, result.getItemId());
            assertEquals(newStock, result.getStock());

            assertNotNull(result.getCreatedAt());
            assertNotNull(result.getUpdatedAt());
            assertEquals(lastCreatedAt, result.getCreatedAt());
            assertNotEquals(lastUpdatedAt, result.getUpdatedAt());
        }
    }


}
