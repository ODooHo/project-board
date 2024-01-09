package com.board.projectboard.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

@DisplayName("비즈니스 로직 - 페이지네이션")
@SpringBootTest
class PaginationServiceTest {

    @Autowired
    private PaginationService sut;


    @DisplayName("현재 페이지 번호와 총 페이지 수를 주면, 페이징 바 리스트를 만들어준다.")
    @MethodSource
    @ParameterizedTest
    void givenCurrentPageNumberAndTotalPages_whenCalculating_thenReturnsPaginationBarNumbers(
            int currentPageNumber,
            int totalPage,
            List<Integer> expected
            ){
        //given


        //when
        List<Integer> actual = sut.getPaginationBarNumbers(currentPageNumber,totalPage);
        //then
        assertThat(actual).isEqualTo(expected);

    }


    static Stream<Arguments> givenCurrentPageNumberAndTotalPages_whenCalculating_thenReturnsPaginationBarNumbers (){
        return Stream.of(
                arguments(1,13,List.of(0,1,2,3,4))
        )
    }

}