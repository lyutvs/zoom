package com.example.zoom.domain.report.domain;

import com.example.zoom.domain.feed.domain.Image;
import com.example.zoom.domain.report.domain.type.ReportType;
import com.example.zoom.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity(name = "zoom_report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private ReportType reportType;

    @Column(length = 15)
    private String title;

    @Column(length = 1000)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporter_email")
    private User reporter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "defendant_email")
    private User defendant;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "report")
    private Result result;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "report")
    private Set<ReportImage> reportImageSet = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "report")
    private FeedReport feedReport;

    @Builder
    public Report(ReportType reportType, String title,
                  String contents, User reporter, User defendant) {
        this.reportType = reportType;
        this.title = title;
        this.contents = contents;
        this.reporter = reporter;
        this.defendant = defendant;
    }


}
