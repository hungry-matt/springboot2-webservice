package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//스프링 부트의 자동 설정, 스프링 bean 읽기와 생성을 모두 자동으로 설정.
//@SpringBootApplication 이 있는 위치부터 설정을 읽음.
//때문에 이 클래스는 항상 프로젝트의 최상단에 위치 해야 한다.
@SpringBootApplication
public class Application {
        public static void main(String[] args) {
            // SpringBootApplication.run : 내장 WAS 실행.
            SpringApplication.run(Application.class, args);
        }
}
