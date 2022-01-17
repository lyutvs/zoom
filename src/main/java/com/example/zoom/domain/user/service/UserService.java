package com.example.zoom.domain.user.service;

import com.example.zoom.domain.user.presentation.dto.request.LoginRequest;
import com.example.zoom.domain.user.presentation.dto.request.SignUpRequest;
import com.example.zoom.domain.refresh_token.presenstation.dto.TokenResponse;

public interface UserService {

    TokenResponse login(LoginRequest request);

    void signup(SignUpRequest request);
}
