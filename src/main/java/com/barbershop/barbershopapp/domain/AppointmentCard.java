package com.barbershop.barbershopapp.domain;

import java.time.LocalDateTime;

public class AppointmentCard {
    private String service;
    private String barber;
    private LocalDateTime appointmentDate;

    public AppointmentCard(String service, String barber, LocalDateTime appointmentDate) {
        this.service = service;
        this.barber = barber;
        this.appointmentDate = appointmentDate;
    }

    // Método para exibir o card de agendamento
    public void displayCard() {
        System.out.println("Serviço: " + service);
        System.out.println("Barbeiro: " + barber);
        System.out.println("Data: " + appointmentDate.toString());
    }

    // Getters e Setters
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getBarber() {
        return barber;
    }

    public void setBarber(String barber) {
        this.barber = barber;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
package com.barbershop.barbershopapp.domain;

import java.time.LocalDateTime;

public class AppointmentCard {
    private String service;
    private String barber;
    private LocalDateTime appointmentDate;

    public AppointmentCard(String service, String barber, LocalDateTime appointmentDate) {
        this.service = service;
        this.barber = barber;
        this.appointmentDate = appointmentDate;
    }

    // Método para exibir o card de agendamento
    public void displayCard() {
        System.out.println("Serviço: " + service);
        System.out.println("Barbeiro: " + barber);
        System.out.println("Data: " + appointmentDate.toString());
    }

    // Getters e Setters
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getBarber() {
        return barber;
    }

    public void setBarber(String barber) {
        this.barber = barber;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
