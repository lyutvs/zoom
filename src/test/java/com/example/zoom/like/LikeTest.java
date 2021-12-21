package com.example.zoom.like;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.feed.domain.repository.domain.Like;
import com.example.zoom.domain.user.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LikeTest {

    @Test
    @DisplayName("Builder 사용해 Like 객채 생성 메소드")
    void createByBuilder() {

        //given
        Feed feed = Feed.builder()
                .title("피드")
                .build();
        User user = User.builder()
                .name("구매자")
                .build();
        //when
        Like like = Like.builder()
                .feed(feed)
                .user(user)
                .build();
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(feed, like.getFeed()),
                () -> Assertions.assertEquals(user, like.getUser())
        );
    }


}
