package com.example.springboot.service.posts;

import com.example.springboot.domain.posts.PostsRepository;
import com.example.springboot.domain.posts.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// final 필드가 포함된 생성자를 생성
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
