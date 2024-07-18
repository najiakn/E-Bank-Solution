package org.example.bank.Auth;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Data
@Builder
public class RegisterRequest {
    public String prenom;
    public String nom;
    private String email;
    private String password;
}
