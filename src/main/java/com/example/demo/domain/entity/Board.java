package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 전략 사용
    private Long number; // 또는 다른 타입을 사용할 수 있음
    private String email;
    private String nickname;
    private String contents;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 유동적으로 바뀌게
    private LocalDateTime date;
    private Long hits;
    private Long like_count;

    @ElementCollection
    private List<String> files;

    // 다대일 관계 설정 (Board 엔터티에서 User 엔터티로의 연관관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    private User user;
}