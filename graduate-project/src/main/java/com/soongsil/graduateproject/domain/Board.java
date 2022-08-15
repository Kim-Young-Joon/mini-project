package com.soongsil.graduateproject.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    private String content;

    private LocalDateTime date;

}
