package com.springboot.demo.service;

import com.springboot.demo.dto.BoardDto;
import com.springboot.demo.dto.MemberDto;
import com.springboot.demo.dto.report.BoardReportDto;
import com.springboot.demo.dto.report.MemberReportDto;
import com.springboot.demo.repository.MemberRepository;
import com.springboot.demo.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private MemberRepository memberRepository;
    private MemberService memberService;
    private BoardService boardService;
    private ReportRepository reportRepository;

    public Object findInfo() {
        return null;
    }

    public List<MemberDto> findAllUsers() {
        return memberService.findAll();
    }

    public List<BoardDto> findAllBoards() {
        return boardService.findAllBoards();
    }

    public List<MemberReportDto> findAllReportedUsers() {
        return reportRepository.findReportByAccusedBoardIsNull().stream()
                .map(r-> MemberReportDto.builder()
                        .id(r.getId())
                        .title(r.getTitle())
                        .reason(r.getReason())
                        .Reporter(r.getReporter())
                        .accusedPerson(r.getAccusedPerson())
                        .build())
                .collect(Collectors.toList());


    }

    public List<BoardReportDto> findAllReportedBoards() {
        return reportRepository.findReportByAccusedBoardIsNotNull().stream()
                .map(r-> BoardReportDto.builder()
                        .id(r.getId())
                        .title(r.getTitle())
                        .reason(r.getReason())
                        .Reporter(r.getReporter())
                        .accusedPerson(r.getAccusedPerson())
                        .accusedBoard(r.getAccusedBoard())
                        .build())
                .collect(Collectors.toList());
    }
}
