package com.grizz.inventoryapp.inventory.repository;

import com.grizz.inventoryapp.test.exception.NotImplementedTestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InventoryJpaRepositoryTest {

    @Nested
    class FindByItemId { // query method
        @DisplayName("itemId를 갖는 entity가 없다면 empty를 반환한다.")
        @Test
        void test1() {
            throw new NotImplementedTestException();
            //given

            //when

            //then

        }

        @DisplayName("itemId를 갖는 entity가 있다면, entity를 반환한다.")
        @Test
        void test2() {
            throw new NotImplementedTestException();
            //given

            //when

            //then

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
