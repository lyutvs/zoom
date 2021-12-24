package com.example.zoom.domain.user.presentation;

import com.example.zoom.domain.user.presentation.dto.request.LoginRequest;
import com.example.zoom.domain.user.presentation.dto.request.RefreshTokenRequest;
import com.example.zoom.domain.user.service.UserService;
import com.example.zoom.global.util.jwt.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/auth")
    public TokenResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @PutMapping("/auth")
    public TokenResponse tokenRefresh(@RequestBody RefreshTokenRequest request) {
        return userService.tokenRefresh(request);
    }

}
