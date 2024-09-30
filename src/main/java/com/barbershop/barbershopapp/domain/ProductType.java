package com.trimtime.app.domain;

import lombok.Getter;

@Getter
public enum ProductType {
    CORTE_CABELO("Corte de Cabelo", 35.0),
    BARBA("Barba", 25.0),
    BARBOTERAPIA("Barboterapia", 35.0),
    PEZINHO("Pezinho", 15.0),
    PERSONALIZADO("Serviço Personalizado", 0.0); // O preço será calculado dinamicamente

    private final String name;
    private double price; // Preço editável

    ProductType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
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

