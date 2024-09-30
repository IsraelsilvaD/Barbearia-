package com.trimtime.app.domain;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private String userName;
    private List<AppointmentCard> appointments;
    private List<ServiceCard> services;

    // Construtor
    public Home(String userName) {
        this.userName = userName;
        this.appointments = new ArrayList<>();
        this.services = new ArrayList<>();
        initializeServices();
    }

    // Método para inicializar os serviços disponíveis
    private void initializeServices() {
        services.add(new ServiceCard(ProductType.CABELO, 35.0));
        services.add(new ServiceCard(ProductType.BARBA, 25.0));
        services.add(new ServiceCard("Barboterapia", 35.0));
        services.add(new ServiceCard("Pezinho", 15.0));
        services.add(new ServiceCard("Serviço Personalizado", 0.0)); // Para ser expandido
    }

    // Método para exibir a home
    public void displayHome() {
        System.out.println("Bem-vindo, " + userName);
        System.out.println("Início");

        System.out.println("\n--- Agendamentos ---");
        if (appointments.isEmpty()) {
            System.out.println("Nenhum agendamento disponível.");
        } else {
            for (AppointmentCard appointment : appointments) {
                appointment.displayCard();
            }
        }

        System.out.println("\n--- Serviços Disponíveis ---");
        for (ServiceCard service : services) {
            service.displayCard();
        }
    }

    // Método para adicionar agendamentos
    public void addAppointment(AppointmentCard appointment) {
        appointments.add(appointment);
    }

    // Getters e Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
