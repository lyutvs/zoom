package com.example.zoom.domain.refresh_token.presenstation.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserTokenResponse {

    private final String accessToken;

    private final String refreshToken;

    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm:SS")
    private final LocalDateTime expiredAt;

}
