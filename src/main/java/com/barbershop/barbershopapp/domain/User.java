package com.barbershop.barbershopapp.domain;

import jakarta.persistence.*;
import lombok.Data;

import javax.management.relation.Role;
import java.util.Date;

@Data
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private Boolean isBarber;
    private Role role;
    private String resetToken; // Campo para armazenar o token de recuperação de senha

    // Campo de status: enum customizada e não importada de jakarta.transaction
  public enum Role{
      CUSTOMER, // Cliente
        EMPLOYEE, // Colaborador
        ADMIM // Dono da Barbearia com acesso completo
    }

    private Date registrationDate = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }








}
