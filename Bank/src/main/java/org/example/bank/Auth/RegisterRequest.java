package org.example.bank.Auth;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class RegisterRequest {
    public String firstname;
    public String lastname;
    private String email;
    private String password;
}
