package com.example.zoom.domain.refresh_token.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;


@Getter
@Builder
@AllArgsConstructor
@RedisHash
public class RefreshToken {

    @Id
    private final String email;

    @Indexed
    private String refreshToken;

    @TimeToLive
    private Long timeToLive;

    public void updateExp(Long timeToLive) {
        this.timeToLive = timeToLive;
    }

}
