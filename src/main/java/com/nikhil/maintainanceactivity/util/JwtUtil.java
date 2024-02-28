package com.nikhil.maintainanceactivity.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expire}")
    private long expriration;

    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expriration))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public Claims extractClaims(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public String extractUserName(String token){
        return extractClaims(token).getSubject();
    }

    public boolean validateToken(String token){
        try{
            Claims claims = extractClaims(token);
            return !claims.getExpiration().before(new Date());
        }
        catch (Exception e){
            return false;
        }
    }

}
