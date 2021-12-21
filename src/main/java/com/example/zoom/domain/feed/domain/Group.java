package com.example.zoom.domain.feed.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity(name = "zoom_study_group_feed")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer headCount;

    private LocalDate recruitmentDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @Builder
    public Group(Integer headCount, LocalDate recruitmentDate,
                 Feed feed) {
        this.headCount = headCount;
        this.recruitmentDate = recruitmentDate;
        this.feed = feed;
    }
}
