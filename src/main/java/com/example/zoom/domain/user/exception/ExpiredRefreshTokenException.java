package com.example.zoom.domain.user.exception;

import com.example.zoom.global.error.exception.CustomException;
import com.example.zoom.global.error.exception.ErrorCode;

public class ExpiredRefreshTokenException extends CustomException {

    public static CustomException EXCEPTION =
            new ExpiredRefreshTokenException();

    public ExpiredRefreshTokenException() {
        super(ErrorCode.EXPIRED_REFRESH_TOKEN);
    }
}
