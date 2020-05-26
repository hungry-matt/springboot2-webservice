package com.example.springboot.web;

import com.example.springboot.domain.posts.PostsSaveRequestDto;
import com.example.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// final 필드가 포함된 생성자 생성
@RequiredArgsConstructor
// json 을 반환하는 컨트롤러
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
}
