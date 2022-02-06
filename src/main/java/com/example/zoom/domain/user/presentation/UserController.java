package com.example.zoom.domain.user.presentation;

import com.example.zoom.domain.user.presentation.dto.request.SignInRequest;
import com.example.zoom.domain.user.presentation.dto.request.SignUpRequest;
import com.example.zoom.domain.user.service.UserService;
import com.example.zoom.domain.refresh_token.presenstation.dto.AccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<AccessTokenResponse> login(@RequestBody SignInRequest request) {
//        return userService.login(request);
        return null;
    }

    @PutMapping("/auth")
    public void signup(@RequestBody SignUpRequest request) {
        userService.signup(request);
    }

}
