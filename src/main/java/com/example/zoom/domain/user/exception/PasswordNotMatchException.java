package com.example.zoom.domain.user.exception;

import com.example.zoom.global.error.exception.CustomException;
import com.example.zoom.global.error.exception.ErrorCode;

public class PasswordNotMatchException extends CustomException {

    public static final CustomException EXCEPTION =
            new PasswordNotMatchException();
    private PasswordNotMatchException() {
        super(ErrorCode.PASSWORD_NOT_FOUND);
    }
}
