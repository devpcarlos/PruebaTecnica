package com.prueba.tecno.security;

import com.prueba.tecno.exceptions.ExceptionHelper;
import com.prueba.tecno.exceptions.Exceptions;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration}")
    private int jwtExpiration;

    private SecretKey getSecretKey() {
        byte[] decodeKey = Base64.getDecoder().decode(jwtSecret.getBytes(StandardCharsets.UTF_8));
        return Keys.hmacShaKeyFor(decodeKey);
    }

    public String generateToken(final String email,
                                final Long userId,
                                final String name) {
        try {
            //Generar UUID
            String uuid = UUID.randomUUID().toString();

            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + jwtExpiration * 1000L);
            // Agregar reclamaciones privadas
            String token = Jwts.builder()
                    .subject(uuid)
                    .claim("Id", userId)
                    .claim("email", email)
                    .claim("nombre", name)
                    .issuedAt(new Date())
                    .expiration(expiryDate)
                    .signWith(getSecretKey()).compact();

            return token;
        } catch (ExpiredJwtException e) {
            throw ExceptionHelper.unauthorized("El token JWT ha expirado");
        }
    }

    public Claims decode(String token) throws Exceptions {
        try {
            return Jwts.parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (ExpiredJwtException e) {
            throw ExceptionHelper.unauthorized("El token JWT ha expirado");
        }

    }

}


