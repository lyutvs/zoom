package com.example.zoom.domain.user.service;

import com.example.zoom.domain.refresh_token.domain.RefreshToken;
import com.example.zoom.domain.refresh_token.domain.repository.RefreshTokenRepository;
import com.example.zoom.domain.refresh_token.presenstation.dto.UserTokenResponse;
import com.example.zoom.domain.user.domain.User;
import com.example.zoom.domain.user.domain.repository.UserRepository;
import com.example.zoom.domain.user.exception.PasswordNotMatchException;
import com.example.zoom.domain.user.exception.UserNotFoundException;
import com.example.zoom.domain.user.facade.UserFacade;
import com.example.zoom.domain.user.presentation.dto.request.SignInRequest;
import com.example.zoom.domain.user.presentation.dto.request.SignUpRequest;
import com.example.zoom.global.security.jwt.JwtProperties;
import com.example.zoom.global.security.jwt.JwtTokenProvider;
import com.example.zoom.domain.refresh_token.presenstation.dto.AccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final UserFacade userFacade;


    @Override
    @Transactional
    public UserTokenResponse signIn(SignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordNotMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(user.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getEmail());


        refreshTokenRepository.save(
                RefreshToken.builder()
                        .email(user.getEmail())
                        .refreshToken(refreshToken)
                        .timeToLive(jwtProperties.getRefreshExp())
                        .build()
        );

        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public void signup(SignUpRequest request) {

    }
}
