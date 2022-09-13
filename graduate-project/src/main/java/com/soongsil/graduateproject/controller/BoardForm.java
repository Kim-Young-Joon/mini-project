package com.soongsil.graduateproject.controller;

import com.soongsil.graduateproject.domain.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class BoardForm {
    // BoardForm 내용 채우기

    private Member member;

    @NotEmpty(message = "제목을 필수로 입력하십시오.")
    private String title;

    @NotEmpty(message = "내용을 필수로 입력하십시오.")
    private String content;

    // 작성일은 자동 입력처리
}
