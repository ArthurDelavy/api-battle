package com.ong.acolhepatinhas.api.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.ong.acolhepatinhas.api.auth.DTO.TokenResponse;
import com.ong.acolhepatinhas.api.security.TokenService;

@Service
@Validated
public class AuthService {

    @Autowired
    private TokenService tknSvc;
    
    
    public TokenResponse issueGuestToken() {
        String authToken = tknSvc.generateToken();
        return new TokenResponse(authToken);
    }
}
