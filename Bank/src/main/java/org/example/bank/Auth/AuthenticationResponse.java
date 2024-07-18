package org.example.bank.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class AuthenticationResponse {




    public String token;
}
