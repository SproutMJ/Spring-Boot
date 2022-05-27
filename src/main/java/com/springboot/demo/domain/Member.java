package com.springboot.demo.domain;

import lombok.*;

import javax.persistence.*;


@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    String name;

    @Column(unique = true)
    String userId;

    @Column
    String password;

}
