package com.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//테스트를 진행할 때 Junit 에 내장된 실행자 외에 다른 실행자를 실행 시킨다.
//스프링 부트 테스트와 Junit 사이에 연결자 역할.
@RunWith(SpringRunner.class)
//Web(Spring mvc)에 집중되어 있는 어노테이션
//선언할 경우 @Controller ,@ControllerAdvice 등을 사용할 수 있다.
//Service, Repository 는 사용 불가.
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    //스프링 빈 주입.
    @Autowired
    //스프링 MVC 테스트의 시작점.
    //이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        //MockMvc 를 통해 /hello 주소로 HTTP Get 요청.
        mvc.perform(get("/hello"))
                //mvc.perform 의 결과를 검증 한다.
                //200, 404, 500 등의 HTTP Header Status 검증 한다.
                //status 가 200 인지 검증.
                .andExpect(status().isOk())
                //응답 본문의 내용을 검증한다.
                //Controller 에서 "hello" 를 리턴하기 때문에 이 값이 맞는지 검증.
                .andExpect(content().string(hello))
                .andDo(MockMvcResultHandlers.print());// test 응답 결과에 대한 모든 내용 출력
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                //요청 파라미터 설정
                //String 만 허용된다.
                .param("name", name)
                .param("amount", String.valueOf(amount))
                )
                .andExpect(status().isOk())
                //json 응답값을 필드별로 검증할 수 있는 메소드
                //$를 기준으로 필드명을 명시
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)))
                .andDo(MockMvcResultHandlers.print());
    }
}
