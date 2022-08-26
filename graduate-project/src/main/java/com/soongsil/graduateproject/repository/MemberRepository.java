package com.soongsil.graduateproject.repository;

import com.soongsil.graduateproject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //추가로 필요한 메서드
}
