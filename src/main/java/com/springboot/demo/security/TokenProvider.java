package com.springboot.demo.security;

import com.springboot.demo.domain.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class TokenProvider {
    private static final String SECRIT_KEY = "ERAHGR5836ASDF";

    public String create(Member member){
        Date expire = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRIT_KEY)
                .setSubject(member.getUserId())
                .setIssuer("spring demo")
                .setIssuedAt(new Date())
                .setExpiration(expire)
                .compact();
    }

    public String validateAndSetUserId(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SECRIT_KEY)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
