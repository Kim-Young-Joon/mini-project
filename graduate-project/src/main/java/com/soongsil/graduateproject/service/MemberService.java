package com.soongsil.graduateproject.service;

import com.soongsil.graduateproject.domain.Member;
import com.soongsil.graduateproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원 가입
    @Transactional
    public Member join(Member member){
        memberRepository.save(member);
        return member;
    }
}
