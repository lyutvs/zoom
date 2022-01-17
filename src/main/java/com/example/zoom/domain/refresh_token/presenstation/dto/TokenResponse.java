package com.example.zoom.domain.refresh_token.presenstation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TokenResponse {

    private final String accessToken;

    private final String refreshToken;

    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm:SS")
    private final LocalDateTime expiredAt;
}
