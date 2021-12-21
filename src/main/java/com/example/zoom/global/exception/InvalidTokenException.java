package com.example.zoom.global.exception;

import com.example.zoom.domain.user.exception.BlackException;
import com.example.zoom.global.error.exception.CustomException;
import com.example.zoom.global.error.exception.ErrorCode;

public class InvalidTokenException extends CustomException {

    public static CustomException EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
