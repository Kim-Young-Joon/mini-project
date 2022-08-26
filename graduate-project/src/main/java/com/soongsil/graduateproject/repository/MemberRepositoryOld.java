package com.soongsil.graduateproject.repository;

import com.soongsil.graduateproject.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryOld {

    private final EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public Long delete(Member member){
        em.createQuery("delete from Member m where m.id = :id")
                .setParameter("id", member.getId())
                .getSingleResult();
        return member.getId();
    }
}
