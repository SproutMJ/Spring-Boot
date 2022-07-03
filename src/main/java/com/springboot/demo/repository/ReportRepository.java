package com.springboot.demo.repository;

import com.springboot.demo.domain.member.Member;
import com.springboot.demo.domain.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    //사람만 신고
    public List<Report> findReportByAccusedBoardIsNull();

    public List<Report> findReportByAccusedBoardIsNotNull();
}
