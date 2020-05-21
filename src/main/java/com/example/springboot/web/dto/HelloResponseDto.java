package com.example.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//선언된 모든 필드의 get 메소드를 생성해 준다.
@Getter
//선언된 모든 final 필드를 포함한 생성자 생성
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
