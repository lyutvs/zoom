package com.example.zoom.domain.report.domain.repository;

import com.example.zoom.domain.report.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
