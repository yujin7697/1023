package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    @Id
    @Column(unique = true)
    private String email;
    private String password;

    private String nickname;
    private String name;
    private String phone;
    private String birth;
    private String zipcode;
    private String addr1;
    private String addr2;
    private String role;
    private String profile; //프로필 사진 저장
    private String question;
    private String answer;

    // 일대다 관계 설정 (User 엔터티와 Board 엔터티 간)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Board> boards;


    //OAuth2 Added
    private String provider;
    private String providerId;




}