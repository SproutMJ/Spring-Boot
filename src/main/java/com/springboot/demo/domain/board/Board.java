package com.springboot.demo.domain.board;

import com.springboot.demo.domain.member.Member;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class Board {
    @Id
    @Column(name = "BOARD_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private Long like;

    @Lob
    private String text;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    public void setMember(Member member){
        this.member = member;

        if(!member.getBoards().contains(member))
            member.getBoards().add(this);
    }
}
