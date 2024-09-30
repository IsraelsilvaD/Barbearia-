package com.trimtime.app.domain;

public class ServiceCard {
    private String serviceName;
    private double price;

    public ServiceCard(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public ServiceCard(ProductType productType, double price) {
        this.serviceName = productType.getName();
        this.price = price;
    }

    // Método para exibir o card do serviço
    public void displayCard() {
        System.out.println("Serviço: " + serviceName);
        System.out.println("Preço: R$ " + price);
    }

    // Getters e Setters
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

