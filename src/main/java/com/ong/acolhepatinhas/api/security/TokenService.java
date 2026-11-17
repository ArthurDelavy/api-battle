package com.ong.acolhepatinhas.api.security;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class TokenService {

    @Value("${app.tokenIssuer}")
    private String ISSUER;
    
    @Value("${app.jwtTokenExpirationMs}")
    private Long EXPIRATION_TIME;
    
    @Value("${api.security.token.secret}")
    private String SECRET;


    public String generateToken() {
        try {
            return JWT.create()
                .withIssuer(ISSUER)
                .withSubject("guest-" + UUID.randomUUID())
                .withClaim("roles", List.of("ROLE_GUEST"))
                .withExpiresAt(Instant.now().plusMillis(EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET));
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token JWT", e);
        }
    }

    public DecodedJWT validateToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(SECRET))
                .withIssuer(ISSUER)
                .build()
                .verify(token);
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}