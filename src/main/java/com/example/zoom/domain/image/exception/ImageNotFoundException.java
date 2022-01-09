package com.example.zoom.domain.image.exception;

import com.example.zoom.global.error.exception.CustomException;
import com.example.zoom.global.error.exception.ErrorCode;

public class ImageNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new ImageNotFoundException();

    private ImageNotFoundException() {
        super(ErrorCode.IMAGE_NOT_FOUND);
    }
}
