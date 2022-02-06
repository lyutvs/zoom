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
    USER_ALREADY_EXISTS(409,"User already exists"),
    FEED_NOT_FOUND(404, "Feed not found"),
    CREDENTIAL_NOT_FOUND(404,"Credential not found"),
    IMAGE_NOT_FOUND(404, "Image not found"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh token not found"),

    USER_ALREADY_EXISTS(409,"User already exists"),
    PASSWORD_NOT_FOUND(404,"Password not found");
    

    private final int status;
    private final String message;
}
