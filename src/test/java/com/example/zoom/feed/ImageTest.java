package com.example.zoom.feed;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.feed.domain.Image;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ImageTest {

    @Test
    @DisplayName("Builder사용해 Image객체 생성 메소드")
    void createByBuilder() {

        //given
        Feed feed = Feed.builder()
                .title("제목")
                .build();
        String path = "경로";
        //then
        Image image = Image.builder()
                .feed(feed)
                .path(path)
                .build();
        //when
        Assertions.assertAll(
                () -> Assertions.assertEquals(feed, image.getFeed()),
                () -> Assertions.assertEquals(path, image.getPath())
        );
    }

}
