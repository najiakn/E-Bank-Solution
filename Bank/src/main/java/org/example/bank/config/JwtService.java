package org.example.bank.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.function.Function;

@Service

public class JwtService {
    private static final String SECRET_KEY="";
    public String extracUsername(String token) {
        return null;
    }
    public <T>T extractClaim(String token, Function<Claims,T>claimResolver){
        final Claims claims=extractAllClaims(token);
        return claimResolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigninKey()).build()
                .parseClaimsJwt(token)
                .getBody();
    }
    private Key getSigninKey(){
byte []KeyBytes= Decoders.BASE64.decode(SECRET_KEY);
return Keys.hmacShaKeyFor(KeyBytes);
    }
}
