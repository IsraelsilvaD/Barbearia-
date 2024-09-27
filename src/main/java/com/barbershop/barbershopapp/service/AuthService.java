package com.barbershop.barbershopapp.service;

import com.barbershop.barbershopapp.domain.RegisterRequest;
import com.barbershop.barbershopapp.domain.User;
import com.barbershop.barbershopapp.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;  // Repositório fictício de usuários

    @Autowired
    private EmailService emailService;  // Serviço fictício de e-mail

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;  // Codificação de senha

    private final String SECRET_KEY = "your-very-secret-key";  // Use uma chave segura
    private final long jwtExpiration = 604800000;  // Expiração do JWT (7 dias)

    // Método para registrar um novo usuário
    public User register(RegisterRequest registerRequest) {
        User user = new User();
        user.setName(registerRequest.getName());
        user.setPhone(registerRequest.getPhone());
        user.setEmail(registerRequest.getEmail());

        // Codifica a senha
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(User.Role.CUSTOMER);  // Define o papel do usuário

        // Salva o usuário no banco de dados
        return saveUserToDatabase(user);
    }

    private User saveUserToDatabase(User user) {
        // Lógica para salvar o usuário no banco de dados
        return userRepository.save(user);
    }

    // Método de autenticação e geração de token
    public String login(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return generateToken(email);
    }

    // Geração do JWT
    private String generateToken(String email) {
        SecretKey key = getSigningKey();
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))  // Expiração em 7 dias
                .signWith(key, SignatureAlgorithm.HS512)  // Assinatura com chave secreta
                .compact();
    }

    // Geração da chave secreta para o token
    private SecretKey getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY);
        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS512.getJcaName());
    }

    // Método para enviar o token de recuperação de senha
    public void sendPasswordResetToken(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("E-mail não encontrado"));

        // Gera um token de recuperação (pode ser UUID ou JWT)
        String resetToken = UUID.randomUUID().toString();
        user.setResetToken(resetToken);
        userRepository.save(user);

        // Envia o token por e-mail
        emailService.sendEmail(email, "Recuperação de Senha", "Seu token de recuperação: " + resetToken);
    }

    // Método para redefinir a senha com o token
    public void resetPassword(String token, String newPassword) {
        User user = userRepository.findByResetToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Token inválido"));

        // Codifica a nova senha e remove o token
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetToken(null);
        userRepository.save(user);
    }
}
