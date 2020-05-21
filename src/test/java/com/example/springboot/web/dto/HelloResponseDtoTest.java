package com.example.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombokTest() {
        String name = "name";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //assetTaht: assertJ 테스트 검증 라이브러리의 검증 메소드
        //isEqualTo: assertThat에 있는 값과 비교
        //Junit을 사용하게 되면 다른라이브러리를 추가로 필요하기 때문에 assertJ 를 사용
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);


    }
}
