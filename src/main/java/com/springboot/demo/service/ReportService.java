package com.springboot.demo.service;

import com.springboot.demo.domain.report.Report;
import com.springboot.demo.dto.report.BoardReportDto;
import com.springboot.demo.dto.report.MemberReportDto;
import com.springboot.demo.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReportService {
    private ReportRepository reportRepository;

    public void reportBoard(BoardReportDto boardReportDto) {

        reportRepository.save(Report.builder()
                .title(boardReportDto.getTitle())
                .reason(boardReportDto.getReason())
                .reporter(boardReportDto.getReporter())
                .accusedPerson(boardReportDto.getAccusedPerson())
                .accusedBoard(boardReportDto.getAccusedBoard())
                .build());
    }

    public void reportUser(MemberReportDto memberReportDto) {
        reportRepository.save(Report.builder()
                .title(memberReportDto.getTitle())
                .reason(memberReportDto.getReason())
                .reporter(memberReportDto.getReporter())
                .accusedPerson(memberReportDto.getAccusedPerson())
                .accusedBoard(null)
                .build());
    }
}
