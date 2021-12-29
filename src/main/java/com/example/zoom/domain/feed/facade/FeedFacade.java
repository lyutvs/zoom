package com.example.zoom.domain.feed.facade;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.feed.domain.repository.FeedRepository;

import com.example.zoom.domain.feed.exception.FeedNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedFacade {

    private final FeedRepository feedRepository;

    public Feed getFeedById(Long feedId) {
        return feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }
}
