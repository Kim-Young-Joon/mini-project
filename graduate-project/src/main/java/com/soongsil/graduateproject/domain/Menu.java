package com.soongsil.graduateproject.domain;

import javax.persistence.*;

@Entity
public class Menu {

    @Id @GeneratedValue
    @Column(name = "menu_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;

    private String name;

    private Long price;

    private String category;
}
