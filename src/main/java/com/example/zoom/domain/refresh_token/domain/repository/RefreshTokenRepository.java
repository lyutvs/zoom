package com.example.zoom.domain.refresh_token.domain.repository;

import com.example.zoom.domain.refresh_token.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);
}
