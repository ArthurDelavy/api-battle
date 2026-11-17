package com.ong.acolhepatinhas.api.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ong.acolhepatinhas.api.auth.DTO.TokenResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação", description = "Autenticação de contas de usuários")
public class AuthController {

    @Autowired
    private AuthService authSvc;


    @PostMapping("/login")
    @Operation(summary = "Login de usuário")
        @ApiResponse(responseCode = "200", description = "Usuário autenticado com sucesso!")
        @ApiResponse(responseCode = "400", description = "Um ou mais campos estão com valores inválidos", content = @Content)
        @ApiResponse(responseCode = "401", description = "Usuário e/ou senha incorretos", content = @Content)
    public ResponseEntity<TokenResponse> authenticateUser() {
        return ResponseEntity.ok(authSvc.issueGuestToken());
    }

}