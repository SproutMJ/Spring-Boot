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

    //이하 dto로 고쳐야됨 아니면 ID로
    private Member reporter;
    private Member accusedPerson;
    private Board accusedBoard;
}
