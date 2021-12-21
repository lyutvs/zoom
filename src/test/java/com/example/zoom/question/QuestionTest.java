package com.example.zoom.question;

import com.example.zoom.domain.user.domain.User;
import com.example.zoom.domain.question.domain.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuestionTest {

    @Test
    @DisplayName("Builder 사용해 Question 객체 생성 메소드")
    void createByBuilder() {

        //given
        String title = "제목";
        String description = "설명";
        User user = User.builder()
                .name("지물자")
                .build();
        //when
        Question question = Question.builder()
                .title(title)
                .description(description)
                .user(user)
                .build();
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(title, question.getTitle()),
                () -> Assertions.assertEquals(description, question.getDescription()),
                () -> Assertions.assertEquals(user, question.getUser())
        );
    }


}
