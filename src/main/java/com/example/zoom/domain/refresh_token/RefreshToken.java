package com.example.zoom.domain.refresh_token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import javax.persistence.Id;

@Getter
@Builder
@AllArgsConstructor
@RedisHash
public class RefreshToken {

    @Id
    private final String email;

    private String token;

    @TimeToLive
    private Long ttl;

    public RefreshToken update(String token, Long ttl) {
        this.token = token;
        this.ttl = ttl;
        return this;
    }


}
