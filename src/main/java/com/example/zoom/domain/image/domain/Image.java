package com.example.zoom.domain.image.domain;

import com.example.zoom.domain.feed.domain.Feed;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "zoom_feed_image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String path;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @Builder
    public Image(String path, Feed feed, String imageUrl) {
        this.path = path;
        this.imageUrl = imageUrl;
        this.feed = feed;
    }
}
