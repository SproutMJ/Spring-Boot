package com.springboot.demo.domain.board;

import com.springboot.demo.domain.member.Member;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;


@Data
@Entity
@Table
public class Board {
    @Id
    @Column(name = "BOARD_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long author;

    @Column
    private String title;

    @Lob
    String text;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    Member member;

    public void setMember(Member member){
        this.member = member;

        if(!member.getBoards().contains(member))
            member.getBoards().add(this);
    }
}
