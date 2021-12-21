package com.example.zoom.feed;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.user.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FeedTest {

    @Test
    @DisplayName("Builder를 사용해 Feed 객체 생성 메소드")
    void createVyBuilder() {

        // given
        String title = "제목";
        String description = "설명";
        User user = User.builder()
                .name("사용자")
                .build();

        // when
        Feed feed = Feed.builder()
                .title(title)
                .description(description)
                .user(user)
                .build();

        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(title, feed.getTitle()),
                () -> Assertions.assertEquals(description, feed.getDescription()),
                () -> Assertions.assertEquals(user, feed.getUser())
        );

    }
}
