package com.example.zoom.domain.feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostFeedRequest {

    private String title;
    private String description;
    private List<String> tags;

}
