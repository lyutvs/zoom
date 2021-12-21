package com.example.zoom.domain.user.exception;

import com.example.zoom.global.error.exception.CustomException;
import com.example.zoom.global.error.exception.ErrorCode;

public class BlackException extends CustomException {

    public static CustomException EXCEPTION =
            new BlackException();

    public BlackException() {
        super(ErrorCode.BLACKED);
    }
}
