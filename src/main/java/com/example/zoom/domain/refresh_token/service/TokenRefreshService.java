package com.example.zoom.domain.refresh_token.service;

import com.example.zoom.domain.refresh_token.domain.RefreshToken;
import com.example.zoom.domain.refresh_token.domain.repository.RefreshTokenRepository;
import com.example.zoom.domain.refresh_token.exception.RefreshTokenNotFoundException;
import com.example.zoom.domain.refresh_token.presenstation.dto.AccessTokenResponse;
import com.example.zoom.global.security.jwt.JwtProperties;
import com.example.zoom.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class TokenRefreshService {

    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public AccessTokenResponse execute(String refreshToken) {
        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(jwtTokenProvider.parseToken(refreshToken))
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);
        redisRefreshToken.updateExp(jwtProperties.getRefreshExp());

        String accessToken = jwtTokenProvider.generateAccessToken(redisRefreshToken.getEmail());
        return AccessTokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .build();
    }

}
