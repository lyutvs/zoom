package com.example.zoom.domain.feed.facade;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.feed.domain.Image;
import com.example.zoom.domain.feed.domain.repository.FeedRepository;

import com.example.zoom.domain.feed.domain.repository.ImageRepository;
import com.example.zoom.domain.feed.exception.FeedNotFoundException;
import com.example.zoom.domain.feed.presentation.dto.response.FeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FeedFacade {

    private final FeedRepository feedRepository;
    private final ImageRepository imageRepository;

    public Feed getFeedById(Long feedId) {
        return feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }

    public FeedResponse feedToFeedResponse(Feed feed) {
        FeedResponse response = FeedResponse.builder()
                .description(feed.getDescription())
                .update_time(feed.getUpdate_time())
                .build();

        return response;
    }

    public List<String> Photo(Feed feed) {
        return imageRepository.findByFeedById(feed)
                .stream().map(Image::getPath)
                .collect(Collectors.toList());
    }

}