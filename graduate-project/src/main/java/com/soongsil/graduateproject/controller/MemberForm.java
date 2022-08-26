package com.soongsil.graduateproject.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "아이디는 필수입니다.")
    private String loginId;

    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String password;

    @NotEmpty(message = "이름은 필수입니다.")
    private String name;

    @Email(message = "xxx@xxx.xxx 형태의 이메일로 입력해주세요")
    @NotNull(message = "이메일은 필수입니다.")
    private String eMail;

    @NotEmpty(message = "핸드폰 번호는 필수입니다.")
    private String phoneNumber;

}
