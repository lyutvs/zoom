package com.example.zoom.user;

import com.example.zoom.domain.user.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    @DisplayName("Builder 사용해 User 객체 생성 매소드")
    void createByBuilder() {
        //given
        String email = "test@gmail.com";
        String accountNumber = "47------------KB";

        // when
        User user = User.builder()
                .email(email)
                .accountNumber(accountNumber)
                .name("홍길동")
                .roomNumber("517")
                .build();

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(email, user.getEmail()),
                () -> Assertions.assertEquals(accountNumber, user.getAccountNumber())
        );


    }
}

