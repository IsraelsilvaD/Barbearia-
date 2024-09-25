package com.barbershop.barbershopapp.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CreateOrderRequest {
    private List<Product> products;
    private Long customerId;
    private Long barberId;
    private LocalDate dateAppointment;
}