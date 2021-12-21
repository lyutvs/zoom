package com.example.zoom.global.exception;

import com.example.zoom.global.error.exception.CustomException;
import com.example.zoom.global.error.exception.ErrorCode;

public class ExpiredTokenException extends CustomException {

    public static CustomException EXCEPTION =
            new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPiRED_TOKEN);
    }
}
