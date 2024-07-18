package org.example.bank.Auth;

import lombok.RequiredArgsConstructor;
import org.example.bank.config.JwtService;
import org.example.bank.model.Role;
import org.example.bank.model.UserRepository;
import org.example.bank.model.Utilisateur;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AuthenticationSevice {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = Utilisateur.builder()
                .prenom(request.getPrenom())
                .nom(request.getNom())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build()
                ;
        repository.save(user);
        var jwtToken=jwtService.generateToken(user);
        return  AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
     authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
             request.getEmail(),
             request.getPassword()
     ));
     var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken=jwtService.generateToken(user);
        return  AuthenticationResponse.builder().token(jwtToken).build();


    }
}
