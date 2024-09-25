package com.barbershop.barbershopapp.domain;

import jakarta.persistence.*;
import lombok.Data;
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
    private String password;
    private Boolean isBarber;

    // Campo de status: enum customizada e não importada de jakarta.transaction


    private Date registrationDate = new Date();








}
