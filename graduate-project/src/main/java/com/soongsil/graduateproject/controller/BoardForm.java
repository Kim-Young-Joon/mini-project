package com.soongsil.graduateproject.controller;

import com.soongsil.graduateproject.domain.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter @Setter
public class BoardForm {
    // BoardForm 내용 채우기

    @NotEmpty()
    private Member member;
    // member data 받아오기

    @NotEmpty()
    private String title;

    @NotEmpty()
    private String content;

    // 작성일은 자동 입력처리
}
