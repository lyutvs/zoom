package com.example.zoom.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SignInRequest {

    @NotBlank(message = "email은 Null, 공백을 허용하지 않습니다.")
    private String email;

    @NotBlank(message = "password는 Null, 공백을 허용하지 않습니다.")
    private String password;

}

