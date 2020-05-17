package com.example.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//JSON을 반환하는 컨트롤러로 설정
//@ResponseBody 를 각 메소드마다 선언할 필요가 없어졌다.
@RestController
public class HelloController {

    //HTTP Method 인 Get 의 요청을 받음.
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
