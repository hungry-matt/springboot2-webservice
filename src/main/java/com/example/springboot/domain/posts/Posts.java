package com.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
//기본 생성자 자동 추가
@NoArgsConstructor
//테이블과 링크될 클래스임을 나타낸다.
//기본값으로 클래스의 카멜케이스 이름으로 테이블 이름을 대칭함.
//ex) SalesManager.java -> sales_manager table
@Entity
public class Posts {
    //해당 테이블의 PK 필드를 나탄낸다.
    @Id
    //PK 생성 규칙을 나타낸다.
    //스프링부트 2.0 에서는 GenerationType.IDENTITY 를 추가해야 auto_increment 가 된다.
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    //테이블이 컬럼을 나타내며 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 된다.
    //사용하는 이유는, 기본값 외에 추가로 옵션 변경시 사용한다.
    //문자열의 경우 VARCHAR(255)가 기본인데 아래와 같이 500으로 늘릴수 있다.
    @Column(length = 500, nullable = false)
    private String title;

    //마찬가지로 타입을 TEXT 로 변경할 수 있다.
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //해당 클래스의 빌더 패턴 클래스를 생성
    //생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
