package com.soongsil.graduateproject.service;

import com.soongsil.graduateproject.domain.Member;
import com.soongsil.graduateproject.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("회원 가입 테스트")
    void joinTest(){
        //given
        Member member = new Member("aaa", "1234", "tamtam", "xxx@xxx.com", "1234556");

        //when
        Member savedMember = memberService.join(member);

        //then
        assertThat(member).isEqualTo(memberRepository.findById(savedMember.getId()).get());
    }
}