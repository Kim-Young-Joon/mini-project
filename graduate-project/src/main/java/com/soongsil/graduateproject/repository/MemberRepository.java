package com.soongsil.graduateproject.repository;

import com.soongsil.graduateproject.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    public Long update(Member member){
        //To Do List
        return 1L;
    }
}
