package com.barbershop.barbershopapp.repository;

import com.barbershop.barbershopapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByResetToken(String resetToken); // Para buscar pelo token de recuperação
}
