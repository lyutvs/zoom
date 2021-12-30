package com.example.zoom.domain.feed.service;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.feed.domain.repository.FeedRepository;
import com.example.zoom.domain.feed.facade.FeedFacade;
import com.example.zoom.domain.feed.presentation.dto.request.PostFeedRequest;
import com.example.zoom.domain.feed.presentation.dto.response.FeedResponse;
import com.example.zoom.domain.user.domain.User;
import com.example.zoom.domain.user.domain.repository.UserRepository;
import com.example.zoom.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {

    private final UserRepository userRepository;
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Override
    public FeedResponse postFeed(PostFeedRequest request) {
        User user = userRepository.findById(userFacade.getUserEmail())
            .orElse(null);

        Feed feed = feedRepository.save(
                Feed.builder()
                        .title(request.getTitle())
                        .description(request.getDescription())
                        .build()
        );

    	return feedFacade.feedToFeedResponse(feed, user);
    }

}
