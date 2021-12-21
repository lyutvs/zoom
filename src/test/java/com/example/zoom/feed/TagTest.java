package com.example.zoom.feed;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.feed.domain.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TagTest {

    @Test
    @DisplayName("Builder 사용해 Tag 객체 생성 메소드")
    void createByBuilder() {
        //given
        Feed feed = Feed.builder()
                .title("제목")
                .build();
        String value = "tag";
        //when
        Tag tag = Tag.builder()
                .feed(feed)
                .tag(value)
                .build();
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(feed, tag.getFeed()),
                () -> Assertions.assertEquals(value, tag.getTag())
        );
    }


}
