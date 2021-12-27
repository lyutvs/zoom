package com.example.zoom.global.security.jwt;

import com.example.zoom.domain.refresh_token.RefreshToken;
import com.example.zoom.domain.refresh_token.domain.repository.RefreshTokenRepository;
import com.example.zoom.domain.user.exception.ExpiredAccessTokenException;
import com.example.zoom.domain.user.exception.ExpiredRefreshTokenException;
import com.example.zoom.global.exception.InvalidTokenException;
import com.example.zoom.global.security.jwt.auth.AuthDetailsService;
import com.example.zoom.global.util.jwt.dto.TokenResponse;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final AuthDetailsService authDetailsService;
    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenResponse generateToken(String username) {
        String access = generateAccessToken(username);
        String refresh = generateRefreshToken(username);

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .email(username)
                        .refreshToken(refresh)
                        .ttl(jwtProperties.getRefreshExp())
                        .build()
        );

        return new TokenResponse(access, refresh);
    }


    public String generateAccessToken(String email) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setHeaderParam("typ", "JWT")
                .setSubject(email)
                .claim("type", "access")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getRefreshExp() * 1000))
                .compact();
    }

    public String generateRefreshToken(String email) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setHeaderParam("typ", "JWT")
                .setSubject(email)
                .claim("type", "refresh")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getRefreshExp() * 1000))
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(jwtProperties.getHeader());
        if(bearer != null && bearer.startsWith(jwtProperties.getPrefix())
                && bearer.length() > jwtProperties.getPrefix().length() + 1)
            return bearer.substring(jwtProperties.getPrefix().length() + 1);
        return null;
    }

    public boolean validateToken(String token) {
        return getTokenBody(token)
                .getExpiration().after(new Date());
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService
                .loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String parseRefreshToken(String token) {
        try{

            Claims claims = Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token).getBody();
            if (claims.get("type").equals("refresh")) {
                return claims.getSubject();
            }
            throw new InvalidTokenException();

        } catch (ExpiredJwtException e) {
            throw new ExpiredRefreshTokenException();
        }
    }

    private Claims getTokenBody(String token) {
        if(token == null)
            throw new InvalidTokenException();
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw new ExpiredAccessTokenException();
        } catch (MalformedJwtException | SignatureException e) {
            throw new InvalidTokenException();
        }

    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }


}
