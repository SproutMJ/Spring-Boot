package com.springboot.demo.dto.report;

import com.springboot.demo.domain.member.Member;
import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MemberReportDto {
    @NotNull
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String reason;

    //이하 dto로 고쳐야됨 아니면 ID로
    private Member reporter;
    private Member accusedPerson;
}
