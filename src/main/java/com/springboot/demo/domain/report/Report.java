package com.springboot.demo.domain.report;


import com.springboot.demo.domain.board.Board;
import com.springboot.demo.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@Entity
public class Report {
    @Id
    @Column(name = "REPORT_ID")
    private Long id;

    @Column
    private String title;

    @Column
    private String reason;

    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ManyToOne
    @JoinColumn(name = "REPORTER_ID")
    private Member Reporter;

    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ManyToOne
    @JoinColumn(name = "ACCUSED_PERSON_ID")
    private Member accusedPerson;

    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ManyToOne
    @JoinColumn(name = "ACCUSED_BOARD_ID")
    private Board accusedBoard;
}
