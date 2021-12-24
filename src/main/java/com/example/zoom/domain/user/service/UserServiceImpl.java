package com.example.zoom.domain.user.service;

import com.example.zoom.domain.user.presentation.dto.request.LoginRequest;
import com.example.zoom.domain.user.presentation.dto.request.RefreshTokenRequest;
import com.example.zoom.global.util.jwt.dto.TokenResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Override
    public TokenResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public TokenResponse tokenRefresh(RefreshTokenRequest request) {
        return null;
    }
}
