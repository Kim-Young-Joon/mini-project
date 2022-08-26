package com.soongsil.graduateproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
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

    private boolean isSignUp;

    public void setLoginId(String loginId){
        this.loginId = loginId;
    }

}
