package com.example.zoom.domain.user.service;

import com.example.zoom.domain.user.domain.User;
import com.example.zoom.domain.user.domain.repository.UserRepository;
import com.example.zoom.domain.user.exception.UserNotFoundException;
import com.example.zoom.domain.user.facade.UserFacade;
import com.example.zoom.domain.user.presentation.dto.request.LoginRequest;
import com.example.zoom.domain.user.presentation.dto.request.SignUpRequest;
import com.example.zoom.global.security.jwt.JwtTokenProvider;
import com.example.zoom.domain.refresh_token.presenstation.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserFacade userFacade;

    @Transactional
    @Override
    public TokenResponse login(LoginRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .map(User::getEmail)
                .map(jwtTokenProvider::generateToken)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    @Override
    public void signup(SignUpRequest request) {

        userFacade.existsUseridFilter(request.getEmail());

        request.encodePassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(new User(request));

    }

}
