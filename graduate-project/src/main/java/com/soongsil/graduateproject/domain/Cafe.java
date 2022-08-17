package com.soongsil.graduateproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cafe {

    @Id @GeneratedValue
    @Column(name = "cafe_id")
    private Long id;

    private String name;

    private String city;

}
