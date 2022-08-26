package com.soongsil.graduateproject.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;

    private String password;

    private String name;

    private String eMail;

    private String phoneNumber;

    private boolean isSignUp; // 탈퇴여부

    public void setLoginId(String loginId){
        this.loginId = loginId;
    }

    //정적 팩토리 메서드
    //To do


    public Member(String loginId, String password, String name, String eMail, String phoneNumber) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }
}
