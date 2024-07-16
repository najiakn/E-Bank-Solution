package org.example.bank.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service

public class JwtService {
    private static final String SECRET_KEY="fnFo2YlgFDAw83kFFrACt8QuvA4BGwcgsmt5gdXzhg+REaPHii6LlBd3ldJUingUheWagcfRcVRqMg++UYn/wYXHtPeHo1IONzUlnrPYBMKYX4Z67TeAyepGB0ezegb8aOoOxvEdL7kPnMVMYCcztdApCVGikKGIlqCX0cNbkkNSsXufEyGBZ+TZlUoReDtG8dgsp/PjSnK+5wyX5vZXAlWPPmAJvJhrotEyn76Xd3E/+2bG3hB77h6ZI4WEtwK7eJVNsMjPIL3Q9LnNgzZL2u4RrkKESeBRMi6TXV3/ad4gAoCVMbYgUu6+MuXiewT7CXVo5GPJ2FaEj24vcHi6vIhoF6rp9JNHDIxDPnZyQi8=\n";
    public String extracUsername(String token) {
        return null;
    }


    public <T>T extractClaim(String token, Function<Claims,T>claimResolver){
        final Claims claims=extractAllClaims(token);
        return claimResolver.apply(claims);
    }
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(),userDetails);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extracUsername(token);
        return (username.equals(userDetails.getUsername()))&& !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims ::getExpiration);
    }


    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails) {
return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
        .signWith(getSigninKey(), SignatureAlgorithm.HS256).compact();
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
