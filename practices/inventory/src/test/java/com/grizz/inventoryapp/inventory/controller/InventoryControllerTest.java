package com.grizz.inventoryapp.inventory.controller;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.grizz.inventoryapp.test.exception.NotImplementedTestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(InventoryController.class)
public class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("재고 조회")
    @Nested
    class GetStock {
        @DisplayName("자산(상품)이 존재하지 않을 경우, 404 status와 error를 반환한다.")
        @Test
        void test1() {
            assertNull(mockMvc);
            throw new NotImplementedTestException();
        }

        @DisplayName("정상인 경우, 200 status와 결과를 반환한다.")
        @Test
        void test1000() {
            throw new NotImplementedTestException();
        }
    }

    @DisplayName("재고 차감")
    @Nested
    class DecreaseQuantity {
        @DisplayName("자산(상품)이 존재하지 않을 경우, 404 status와 error를 반환한다.")
        @Test
        void test1() {
            throw new NotImplementedTestException();
        }

        @DisplayName("재고가 부족할 경우, 404 status와 error를 반환한다.")
        @Test
        void test2() {
            throw new NotImplementedTestException();
        }

        @DisplayName("차감 수량이 유효하지 않은 경우, 404 status와 error를 반환한다.")
        @Test
        void test3() {
            throw new NotImplementedTestException();
        }

        @DisplayName("정상인 경우, 200 status와 결과를 반환한다.")
        @Test
        void test1000() {
            throw new NotImplementedTestException();
        }
    }

    @DisplayName("재고 수정")
    @Nested
    class UpdateStock {
        @DisplayName("자산(상품)이 존재하지 않을 경우, 404 status와 error를 반환한다.")
        @Test
        void test1() {
            throw new NotImplementedTestException();
        }

        @DisplayName("수정하려는 재고가 유효하지 않은 경우, 404 status와 error를 반환한다.")
        @Test
        void test2() {
            throw new NotImplementedTestException();
        }

        @DisplayName("정상인 경우, 200 status와 결과를 반환한다.")
        @Test
        void test1000() {
            throw new NotImplementedTestException();
        }
    }
}
