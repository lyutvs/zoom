package com.example.zoom.domain.user.exception;

import com.example.zoom.global.error.exception.CustomException;
import com.example.zoom.global.error.exception.ErrorCode;

public class ExpiredAccessTokenException extends CustomException {

    public static CustomException EXCEPTION =
            new ExpiredAccessTokenException();

    public ExpiredAccessTokenException() {
        super(ErrorCode.EXPIRED_ACCESS_TOKEN);
    }
}
