package com.example.zoom.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    USER_NOT_FOUND(404, "User not Found"),
    BLACKED(403,"You were blacked"),
    INVALID_TOKEN(401, "Invalid token"),
    EXPiRED_TOKEN(401,"Expired token"),
    EXPIRED_ACCESS_TOKEN(401,"Expired access token"),
    EXPIRED_REFRESH_TOKEN(401,"Expired refresh token"),
    ;

    private final int status;
    private final String message;
}
