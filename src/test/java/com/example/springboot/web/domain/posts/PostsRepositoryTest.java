package com.example.springboot.web.domain.posts;

import com.example.springboot.domain.posts.Posts;
import com.example.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//Junit 테스트를 진행할 때 내부 실행자 외에 다른 실행자도 같이 실행.
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    //Junit 에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
    //테스트용 데이터베이스인 H2에 데이터가 남기 때문에 다음 테스트 실행시 테스트 실패의 원인이 되기 때문에 삭제
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //posts 테이블에 insert/update 쿼리를 실행
        //id 값이 있다면 update, 없다면 insert 실행
        postsRepository.save(
                Posts.builder()
                .title(title)
                .content(content)
                .author("email test")
                .build());

        //테이블의 모든 데이터를 조회
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo("email test");
    }

}
