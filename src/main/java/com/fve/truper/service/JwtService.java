package com.fve.truper.service;

import com.fve.truper.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration;

    private String extractUsername(final String token) {
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    private String generateToken(final User user) {
        return buildToken(user, jwtExpiration);
    }

    private String buildToken(final User user, final long expiration) {
        return Jwts
                .builder()
                .id(user.getId().toString())
                .claims(Map.of("name", user.getName()))
                .subject(user.getEmail())
                .issuedAt( new Date(System.currentTimeMillis()))
                .expiration( new Date(System.currentTimeMillis()))
                .signWith(getSignKey())
                .compact();
    }

    private SecretKey getSignKey() {
        final byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
