package com.example.zoom.domain.refresh_token.exception;

import com.example.zoom.global.error.exception.CustomException;
import com.example.zoom.global.error.exception.ErrorCode;

public class RefreshTokenNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException() {
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}
