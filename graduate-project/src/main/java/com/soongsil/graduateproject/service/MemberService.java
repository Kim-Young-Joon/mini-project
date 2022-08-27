package com.soongsil.graduateproject.service;

import com.soongsil.graduateproject.domain.Member;
import com.soongsil.graduateproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

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

    //회원 탈퇴
    @Transactional
    public Member delete(Member member){
        Optional<Member> optionalMember = memberRepository.findById(member.getId());
        //TODO: 리팩토링 해야됨
        try{
            Member findMember = optionalMember.get();
            findMember.setDeleteMember();
        }catch (NoSuchElementException e){
            throw new IllegalStateException(e);
        }
        return member;
    }

    //회원 정보 수정
    @Transactional
    public Member update(Member member){
        //JPA 변경 감지 활용
        Member findMember = memberRepository.findById(member.getId()).get();
        //TODO: 리팩토링 해야됨 -> get()말고 다른 방법 생각하기
        //TODO: setter 대신에 사용할 메서드 정의해야됨. -> 어떤 방법으로 메서드 만들지 고민하기
        return findMember;
    }
}
