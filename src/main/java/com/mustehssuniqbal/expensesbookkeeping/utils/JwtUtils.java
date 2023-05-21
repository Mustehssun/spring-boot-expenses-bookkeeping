package com.mustehssuniqbal.expensesbookkeeping.utils;

import com.mustehssuniqbal.expensesbookkeeping.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    @Value("${expensebookkeeping.jwt.secret}")
    private String secret;

    @Value("${expensebookkeeping.jwt.expirationInMs}")
    private String expirationInMs;

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        Date expirationDate = new Date();
        expirationDate.setTime(new Date().getTime() + Long.parseLong(expirationInMs));

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Boolean validateJwt(String jwt) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt);

            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public String getUsernameFromJwt(String jwt) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt).getBody().getSubject();
    }
}
