package com.springboot.demo.domain.comment;

import com.springboot.demo.domain.board.Board;
import com.springboot.demo.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table
public class Comment {
    @Id
    @Column(name = "COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String comment;

    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}
