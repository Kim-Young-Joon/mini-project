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
public class Member extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;

    private String password;

    private String name;

    private String eMail;

    private String phoneNumber;

    private boolean isSignUp; // 탈퇴여부

    //탈퇴 시 사용할 메서드 -> isSignUp -> false로 바꿔줌
    public void setDeleteMember(){
        this.isSignUp = false;
    }

    //정적 팩토리 메서드
    //TODO:


    public Member(String loginId, String password, String name, String eMail, String phoneNumber) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    //로그인 메서드
    public Member loginLogic(String password) {
        if(this.password.equals(password)){
            return this;
        }
        return null;
    }
}
