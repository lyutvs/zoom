package com.example.zoom.domain.user.service;

import com.example.zoom.domain.refresh_token.presenstation.dto.UserTokenResponse;
import com.example.zoom.domain.user.presentation.dto.request.SignInRequest;
import com.example.zoom.domain.user.presentation.dto.request.SignUpRequest;

public interface UserService {

    UserTokenResponse signIn(SignInRequest signInRequest);

    void signup(SignUpRequest request);
}
