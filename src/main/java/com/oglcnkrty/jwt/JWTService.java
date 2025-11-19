package com.oglcnkrty.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTService {
    private static final String SECRET_KEY = "JAH2TGjQPDiSHP/BaVgAFlrEl3deW9VwhuOktyRoUew=";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setId(userDetails.getUsername())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))
                .signWith(getSecretKey(), SignatureAlgorithm.HS256).compact();
    }

    public <T> T exportToken(String token, Function<Claims, T> claimsFunc) {
        Claims claims = getClaimsFromToken(token);
        return claimsFunc.apply(claims);
    }

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    public Boolean isTokenExpired(String token) {
        return getClaimsFromToken(token).getExpiration().after(new Date());
    }


    public Claims getClaimsFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token).getBody();
        return claims;
    }

    public Key getSecretKey() {
        byte[] bytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }
}
