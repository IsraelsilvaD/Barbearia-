package com.barbershop.barbershopapp.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    String authenticate(String username, String password);
}
