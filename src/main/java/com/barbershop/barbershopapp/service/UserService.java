package com.trimtime.app.service;

import com.trimtime.app.domain.Role;
import com.trimtime.app.domain.User;
import com.trimtime.app.repository.RolesRepository;
import com.trimtime.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final RolesRepository rolesRepository;
    
    private UserRepository userRepository;

    // Obter todos os usuários
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obter usuário por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Criar um novo usuário
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
         Role customerRole = rolesRepository.findByName("CUSTOMER")
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.getRoles().add(customerRole);
        return userRepository.save(user);

    }

    // Atualizar um usuário existente
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setIsBarber(user.getIsBarber());
            return userRepository.save(updatedUser);
        }
        return null;
    }

    // Deletar um usuário pelo ID
    public boolean deleteUser(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
