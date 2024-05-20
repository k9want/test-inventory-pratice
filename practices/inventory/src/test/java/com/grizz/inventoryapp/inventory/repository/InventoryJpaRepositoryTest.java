package com.grizz.inventoryapp.inventory.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.grizz.inventoryapp.inventory.repository.entity.InventoryEntity;
import com.grizz.inventoryapp.test.exception.NotImplementedTestException;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("h2-test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class InventoryJpaRepositoryTest {

    @Autowired
    InventoryJpaRepository sut; // system under test 테스트 대상
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
        @DisplayName("itemId를 갖는 entity가 없다면 0을 반환한다.")
        @Test
        void test1() {
            throw new NotImplementedTestException();

            //given

            //when

            //then
            
        }
        
        @Test
        @DisplayName("itemId를 갖는 entity가 있다면 1을 반환한다.")
        void test2() {
            throw new NotImplementedTestException();

            //given

            //when

            //then
            
        }
    }

    @Nested
    class Save { // 기본
        @DisplayName("id를 갖는 entity가 없다면, entity를 추가하고 추가된 entity를 반환한다.")
        @Test
        void test1() {
            //given
            throw new NotImplementedTestException();

            //when

            //then

        }

        @DisplayName("id를 갖는 entity가 있다면, entity를 수정하고 수정된 entity를 반환한다.")
        @Test
        void test2() {
            //given
            throw new NotImplementedTestException();

            //when

            //then

        }
    }


}
