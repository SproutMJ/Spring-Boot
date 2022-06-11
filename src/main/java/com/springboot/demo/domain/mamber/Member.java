package com.springboot.demo.domain.mamber;

import com.springboot.demo.domain.mamber.auth.Authority;
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

    @Column
    String nickName;

    @Column(unique = true)
    String username;

    @Column
    String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;
}
