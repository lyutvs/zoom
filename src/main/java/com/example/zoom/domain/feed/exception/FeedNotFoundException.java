package com.example.zoom.domain.feed.exception;

import com.example.zoom.global.error.exception.CustomException;
import com.example.zoom.global.error.exception.ErrorCode;

public class FeedNotFoundException extends CustomException {

    public static CustomException EXCEPTION =
            new FeedNotFoundException();

    private FeedNotFoundException() {
        super(ErrorCode.FEED_NOT_FOUND);
    }
}
