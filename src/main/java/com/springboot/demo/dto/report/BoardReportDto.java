package com.springboot.demo.dto.report;

import com.springboot.demo.domain.board.Board;
import com.springboot.demo.domain.member.Member;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BoardReportDto {
    private Long id;
    private String title;
    private String reason;
    private Member Reporter;
    private Member accusedPerson;
    private Board accusedBoard;
}
