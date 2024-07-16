package org.example.bank.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthentificationFilter extends OncePerRequestFilter {
    private  final JwtService jwtService;



    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                  @NonNull HttpServletResponse response,
                                   @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String autheHeader=request.getHeader("Authorization");
         final String jwt;
         final String UserEmail;
         if(autheHeader == null || !autheHeader.startsWith("Bearer ")){
             filterChain.doFilter(request,response);
             return;
         }
         jwt=autheHeader.substring(7);
        UserEmail=jwtService.extracUsername(jwt);

    }
}
