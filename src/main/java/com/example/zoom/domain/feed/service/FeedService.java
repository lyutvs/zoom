package com.example.zoom.domain.feed.service;

import com.example.zoom.domain.feed.presentation.dto.request.PostFeedRequest;
import com.example.zoom.domain.feed.presentation.dto.response.FeedResponse;

public interface FeedService {

    void postFeed(PostFeedRequest request);

}
