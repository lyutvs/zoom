package com.example.zoom.refresh_token;

import com.example.zoom.domain.refresh_token.RefreshToken;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RefreshTokenTest {

    @Test
    @DisplayName("Builder 사용해 Response 객체 생성 메소드")
    void createByBuilder() {
        //given
        String email = "hello@gmail.com";
        String token = "qwerasd1234.qwerasd1234";
        Long ttl = 1234L;
        //when
        RefreshToken refreshToken = new RefreshToken(email, token, ttl);
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(email, refreshToken.getEmail()),
                () -> Assertions.assertEquals(token, refreshToken.getToken()),
                () -> Assertions.assertEquals(ttl, refreshToken.getTtl())
        );
    }
}
