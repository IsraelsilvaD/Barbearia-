package com.trimtime.app.domain;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private ObjectId id;
    private LocalDateTime orderDate;
    private LocalDate orderDateAppointment;
    @NonNull
    private List<Product> products;
    private double totalPrice;
    private User customer;
    private User barber;

    public Order(ObjectId id, LocalDateTime orderDate, @NonNull List<Product> products, User customer, User barber,LocalDate orderDateAppointment) {
        this.id = id;
        this.orderDate = orderDate;
        this.products = products;
        this.customer = customer;
        this.barber = barber;
        this.totalPrice = calculateTotalPrice();
        this.orderDateAppointment = orderDateAppointment;
    }

    private double calculateTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
