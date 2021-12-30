package com.example.zoom.domain.feed.presentation;

import com.example.zoom.domain.feed.presentation.dto.request.PostFeedRequest;
import com.example.zoom.domain.feed.presentation.dto.response.FeedResponse;
import com.example.zoom.domain.feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @PostMapping("/carrot")
    @ResponseStatus(HttpStatus.CREATED)
    public FeedResponse postCarrotFeed(@RequestBody PostFeedRequest request) {
        return feedService.postFeed(request);
    }

}
