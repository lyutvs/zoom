package com.example.zoom.domain.feed.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class FeedResponse {

    private final String description;
    private final LocalDateTime create_time;
    private final LocalDateTime update_time;

    private final List<String> photo;

    @Builder
    public FeedResponse(String description, LocalDateTime create_time,
                        LocalDateTime update_time, List<String> photo) {
        this.description = description;
        this.create_time = create_time;
        this.update_time = update_time;
        this.photo = photo;
    }
}
