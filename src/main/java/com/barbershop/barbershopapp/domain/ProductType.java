package com.barbershop.barbershopapp.domain;

import lombok.Getter;

@Getter
public enum ProductType {
    CABELO("Cabelo", 10.0),
    BARBA("Barba", 15.0),
    CABELO_E_BARBA("Cabelo + Barba", 22.0);

    private final String name;
    private final double price;

    ProductType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public enum Role {
        CUSTOMER("Cliente", "Acesso restrito ao sistema"),
        BARBER("Colaborador", "Acesso estendido para colaboradores"),
        BARBERSHOP("Administração", "Acesso completo para gerenciamento da barbearia");

        private final String name;
        private final String description;

        Role(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }
}


