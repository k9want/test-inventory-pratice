package com.grizz.inventoryapp.inventory.service;

import static org.junit.jupiter.api.Assertions.*;

import com.grizz.inventoryapp.inventory.InventoryService;
import com.grizz.inventoryapp.inventory.service.domain.Inventory;
import com.grizz.inventoryapp.test.exception.NotImplementedTestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InventoryServiceTest {

    InventoryService sut; // system under test (시스템 환경 테스트 - 테스트할 대상을 가리키는 용어)

    @BeforeEach
    void setUpAll() {
        sut = new InventoryService();
    }
    @Nested
    class FindByItemId {
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

            throw new NotImplementedTestException();
        }

        @Nested
        class DecreaseByItemId {
            @DisplayName("qunatity가 음수라면, Exception을 throw한다.")
            @Test
            void test1() {
                throw new NotImplementedTestException();
            }

            @DisplayName("itemId를 갖는 entity를 찾지 못하면, Exception을 throw한다.")
            @Test
            void test2() {
                throw new NotImplementedTestException();
            }

            @DisplayName("quantity가 stock보다 크면, Exception을 throw한다.")
            @Test
            void test3() {
                throw new NotImplementedTestException();
            }

            @DisplayName("재고 차감하려는 entity가 없다면, Exception을 throw한다. - 재고 감소하려고 조회한 후, 찰나의 순간에 상품이 삭제 되었다면?")
            @Test
            void test4() {
                throw new NotImplementedTestException();
            }

            @DisplayName("itemId를 갖는 entity를 찾으면, stock을 차감하고, inventory를 반환한다.")
            @Test
            void test1000() {
                throw new NotImplementedTestException();
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


}
