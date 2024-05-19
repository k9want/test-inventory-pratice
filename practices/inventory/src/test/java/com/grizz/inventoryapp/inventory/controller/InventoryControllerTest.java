package com.grizz.inventoryapp.inventory.controller;

import static com.grizz.inventoryapp.test.assertion.Assertions.assertMvcDataEquals;
import static com.grizz.inventoryapp.test.assertion.Assertions.assertMvcErrorEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.grizz.inventoryapp.config.JsonConfig;
import com.grizz.inventoryapp.inventory.InventoryService;
import com.grizz.inventoryapp.inventory.controller.consts.ErrorCodes;
import com.grizz.inventoryapp.inventory.service.domain.Inventory;
import com.grizz.inventoryapp.test.exception.NotImplementedTestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@Import(JsonConfig.class)
@WebMvcTest(InventoryController.class)
public class InventoryControllerTest {

    // mock + bean
    @MockBean
    private InventoryService inventoryService;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

    @DisplayName("재고 조회")
    @Nested
    class GetStock {

        final String itemId = "1";
        final Long stock = 100L;
        @DisplayName("자산(상품)이 존재하지 않을 경우, 404 status와 error를 반환한다.")
        @Test
        void test1() throws Exception {
            // given
            given(inventoryService.findByItemId(itemId))
                .willReturn(null);

            // when
            final MvcResult result = mockMvc.perform(get("/api/v1/inventory/{itemId}", itemId))
                .andExpect(status().isNotFound())
                .andReturn();

            // then
            assertMvcErrorEquals(result, ErrorCodes.ITEM_NOT_FOUND);
        }


        @DisplayName("정상인 경우, 200 status와 결과를 반환한다.")
        @Test
        void test1000() throws Exception {

            // given
            final Inventory inventory = new Inventory(itemId, stock);
            given(inventoryService.findByItemId(itemId))
                .willReturn(inventory);

            // when
            final MvcResult result = mockMvc.perform(get("/api/v1/inventory/{itemId}", itemId))
                .andExpect(status().isOk())
                .andReturn();

            // then
            assertMvcDataEquals(result, dataField -> {
                assertEquals(itemId, dataField.get("item_id").asText());
                assertEquals(stock, dataField.get("stock").asLong());
            });
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
