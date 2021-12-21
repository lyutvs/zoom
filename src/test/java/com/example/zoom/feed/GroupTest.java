package com.example.zoom.feed;

import com.example.zoom.domain.feed.domain.Feed;
import com.example.zoom.domain.feed.domain.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class GroupTest {

    @Test
    @DisplayName("Builder사용해 Group 객체 생성 메소드")
    void createByBuilder() {

        //given
        LocalDate date = LocalDate.of(2021,12,21);
        Feed feed = Feed.builder()
                .title("제목")
                .build();
        //when
        Group group = Group.builder()
                .feed(feed)
                .recruitmentDate(date)
                .headCount(10)
                .build();
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(date, group.getRecruitmentDate()),
                () -> Assertions.assertEquals(feed, group.getFeed())
        );

    }

}
