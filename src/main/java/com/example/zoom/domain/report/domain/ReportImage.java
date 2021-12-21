package com.example.zoom.domain.report.domain;

import com.example.zoom.domain.report.domain.Report;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "zoom_report_image")
public class ReportImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    private Report report;

    @Builder
    public ReportImage(String path, Report report) {
        this.path = path;
        this.report = report;
    }



}
