package com.example.zoom.domain.refresh_token.domain.repository;

import java.util.Optional;

import com.example.zoom.domain.refresh_token.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);
}