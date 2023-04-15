package com.leetcode.util.jwt;

import com.leetcode.domain.User;
import com.leetcode.util.config.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTUtils {
    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.expiration.min}")
    private long expiration;

    public String extractUsername(@NonNull String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        JwtParser jwtParser = Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build();
        Jws<Claims> claimsJws = jwtParser
                .parseClaimsJws(token);
        return claimsJws.getBody();
    }

    public boolean isTokenValid(String token, UserDetailsImpl userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Map<String , Object> extraClaims, User authUser) {

        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(authUser.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000 * 60))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
