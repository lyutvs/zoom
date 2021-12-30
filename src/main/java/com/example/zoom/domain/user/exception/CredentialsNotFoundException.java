package com.example.zoom.domain.user.exception;

import com.example.zoom.global.error.exception.CustomException;
import com.example.zoom.global.error.exception.ErrorCode;

public class CredentialsNotFoundException extends CustomException {

    public CustomException EXCEPTION =
            new CredentialsNotFoundException();

    private CredentialsNotFoundException( ) {
        super(ErrorCode.CREDENTIAL_NOT_FOUND);
    }
}
