package com.example.zoom.domain.feed.service;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.feed.facade.FeedFacade;
import com.example.zoom.domain.feed.presentation.dto.request.PostFeedRequest;
import com.example.zoom.domain.user.domain.User;
import com.example.zoom.domain.user.domain.repository.UserRepository;
import com.example.zoom.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Override
    public void postCarrotFeed(PostFeedRequest request) {
        User user = userRepository.findById(userFacade.getUserEmail())
            .orElse(null);

    Feed feed = feedFacade.getFeedById(feedId);

    	return feedFacade.feedToFeedResponse(feed, user);
}

}
