package com.example.zoom.domain.like.domain;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "zoom_Like")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @Builder
    public Like(User user, Feed feed) {
        this.user = user;
        this.feed = feed;
    }


}
