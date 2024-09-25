package com.barbershop.barbershopapp.service;

import com.barbershop.barbershopapp.util.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final String SECRET_KEY = "Y2hhbGxlbmdlZCBzZWNyZXQgaXMgbm90IHlldCBmYWNlIHNjb3JlZCBjYXVzZSB0byBhbW9nIHN0YXR1cyBmb2xsb3dpbmcgYmFzZWQgc29ya3MgYW5kIHJhdGhlciBhbGdvcml0aG0gdW5zZXMu"; // Use a secure secret key
    private final long jwtExpiration = 604800000; // 7 days in milliseconds

    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setJwtUtil(JwtUtil jwtUtil) {
    }
    @Override
    public String authenticate(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        return generateToken(email);
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY); // Decode if using Base64
        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS512.getJcaName());
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .signWith(getSigningKey(), SignatureAlgorithm.HS512) // Specify the algorithm here
                .compact();
    }

    public UserDetails loadUserByUsername(String username) {
        return userDetailsService.loadUserByUsername(username);
    }
}
