package com.grizz.inventoryapp.inventory.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import com.grizz.inventoryapp.inventory.InventoryService;
import com.grizz.inventoryapp.inventory.repository.InventoryJpaRepositoryStub;
import com.grizz.inventoryapp.inventory.service.domain.Inventory;
import com.grizz.inventoryapp.inventory.service.exception.InsufficientStockException;
import com.grizz.inventoryapp.inventory.service.exception.InvalidDecreaseQuantityException;
import com.grizz.inventoryapp.inventory.service.exception.ItemNotFoundException;
import com.grizz.inventoryapp.test.exception.NotImplementedTestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {

    @InjectMocks
    InventoryService sut; // system under test (시스템 환경 테스트 - 테스트할 대상을 가리키는 용어)

    @Spy
    InventoryJpaRepositoryStub inventoryJpaRepository;


    @Nested
    class FindByItemId {
        final String existingItemId = "1";
        final Long stock = 10L;
        @BeforeEach
        void setUpAll() {
            inventoryJpaRepository.addInventoryEntity(existingItemId, stock);
        }

        @DisplayName("itemId를 갖는 entity를 찾지 못하면, null을 반환한다.")
        @Test
        void test1() {
            // given
            final String nonExistingItemId = "2";
            // when
            final Inventory result = sut.findByItemId(nonExistingItemId);
            // then
            assertNull(result);
        }

        @DisplayName("itemId를 갖는 entity를 찾으면, inventory를 반환한다.")
        @Test
        void test1000() {
            // given
            final String existingItemId = "1";
            final Long stock = 10L;

            // when
            final Inventory result = sut.findByItemId(existingItemId);

            // then
            assertNotNull(result);
            assertEquals(existingItemId, result.getItemId());
            assertEquals(stock, result.getStock());
        }
    }

    @Nested
    class DecreaseByItemId {
        final String existingItemId = "1";
        final Long stock = 100L;

        @BeforeEach
        void setUpAll() {
            inventoryJpaRepository.addInventoryEntity(existingItemId, stock);
        }
        @DisplayName("qunatity가 음수라면, Exception을 throw한다.")
        @Test
        void test1() {
            // given
            final Long quantity = -1L;
            // when
            assertThrows(InvalidDecreaseQuantityException.class, () -> {
                sut.decreaseByItemId(existingItemId, quantity);
            });
        }

        @DisplayName("itemId를 갖는 entity를 찾지 못하면, Exception을 throw한다.")
        @Test
        void test2() {
            // given
            final Long quantity = 10L;
            final String nonExistingItemId = "2";

            // when
            assertThrows(ItemNotFoundException.class, () -> {
                sut.decreaseByItemId(nonExistingItemId, quantity);
            });
        }

        @DisplayName("quantity가 stock보다 크면, Exception을 throw한다.")
        @Test
        void test3() {
            // given
            final Long quantity = stock + 1;

            // when
            assertThrows(InsufficientStockException.class, () -> {
                sut.decreaseByItemId(existingItemId, quantity);
            });
        }

        @DisplayName("재고 차감하려는(변경된) entity가 없다면, Exception을 throw한다. - 재고 감소하려고 조회한 후, 찰나의 순간에 상품이 삭제 되었다면?")
        @Test
        void test4() {
            // given
            final Long quantity = 10L;

            // Spy를 통해 동작을 가로채서 0을 return
            doReturn(0).when(inventoryJpaRepository).decreaseStock(existingItemId, quantity);

            // when
            assertThrows(ItemNotFoundException.class, () -> {
                sut.decreaseByItemId(existingItemId, quantity);
            });

            verify(inventoryJpaRepository).decreaseStock(existingItemId, quantity);


        }

        @DisplayName("itemId를 갖는 entity를 찾으면, stock을 차감하고, inventory를 반환한다.")
        @Test
        void test1000() {
            // given
            final Long quantity = 10L;
            // when
            final Inventory result = sut.decreaseByItemId(existingItemId, quantity);

            // then
            assertNotNull(result);
            assertEquals(existingItemId, result.getItemId());
            assertEquals(stock - quantity, result.getStock());
        }
    }

    @Nested
    class UpdateStock {

        @DisplayName("수정할 stock이 유효하지 않다면, Exception을 throw한다.")
        @Test
        void test1() {
            throw new NotImplementedTestException();
        }

        @DisplayName("itemId를 갖는 entity를 찾지 못하면, Exception을 throw한다.")
        @Test
        void test2() {
            throw new NotImplementedTestException();
        }

        @DisplayName("itemId를 갖는 entity를 찾으면, stock을 수정하고 inventory를 반환한다.")
        @Test
        void test1000() {
            throw new NotImplementedTestException();
        }
    }
}
