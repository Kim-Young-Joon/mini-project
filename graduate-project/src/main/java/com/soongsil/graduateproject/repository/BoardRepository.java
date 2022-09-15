package com.soongsil.graduateproject.repository;

import com.soongsil.graduateproject.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select b from Board b join fetch b.member m where b.id = :id")
    Board findBoardById(@Param("id") Long id);
}
