package com.example.zoom.report;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.user.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReportTest {

    @Test
    @DisplayName("Builder 사용해 Report 객체 생성 메소드")
    void createByBuilder() {

        //given
        String title = "제목";
        String description = "설명";
        User user = User.builder()
                .name("사용자")
                .build();

        //when
        Feed feed = Feed.builder()
                .title(title)
                .description(description)
                .user(user)
                .build();

        //given
        Assertions.assertAll(
                () -> Assertions.assertEquals(title, feed.getTitle()),
                () -> Assertions.assertEquals(description, feed.getDescription()),
                () -> Assertions.assertEquals(user, feed.getUser())
        );
    }


}
