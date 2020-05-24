package com.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//보통 ibatis, mybatis 에서 Dao 라고 불리는 DB Layer 접근자 이다.
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
