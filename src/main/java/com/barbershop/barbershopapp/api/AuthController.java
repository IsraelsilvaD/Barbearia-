package com.barbershop.barbershopapp.api;

import com.barbershop.barbershopapp.domain.ForgotPasswordRequest;
import com.barbershop.barbershopapp.domain.RegisterRequest;
import com.barbershop.barbershopapp.domain.ResetPasswordRequest;
import com.barbershop.barbershopapp.domain.User;
import com.barbershop.barbershopapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Endpoint para registrar novos usuários
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest) {
        User newUser = authService.register(registerRequest);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // Endpoint para solicitar recuperação de senha
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        authService.sendPasswordResetToken(request.getEmail());
        return new ResponseEntity<>("Token de redefinição enviado com sucesso", HttpStatus.OK);
    }

    // Endpoint para redefinir a senha
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        authService.resetPassword(request.getToken(), request.getNewPassword());
        return new ResponseEntity<>("Senha redefinida com sucesso", HttpStatus.OK);
    }
}
