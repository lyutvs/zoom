package com.example.zoom.domain.user.service;

import com.example.zoom.domain.user.presentation.dto.request.LoginRequest;
import com.example.zoom.domain.user.presentation.dto.request.RefreshTokenRequest;
import com.example.zoom.global.util.jwt.dto.TokenResponse;

public interface UserService {

    TokenResponse login(LoginRequest request);
    TokenResponse tokenRefresh(RefreshTokenRequest request);
}
