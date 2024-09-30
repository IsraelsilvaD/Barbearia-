package com.trimtime.app.service;

import com.trimtime.app.domain.Order;
import com.trimtime.app.domain.Product;
import com.trimtime.app.domain.User;
import com.trimtime.app.repository.OrderRepository;
import com.trimtime.app.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order createOrder(List<Product> products, Long customerId, Long barberId, LocalDate dateAppointment) throws Exception {
        Optional<User> customerDb = userRepository.findById(customerId);
        Optional<User> barberDb = userRepository.findById(barberId);
        User customer;
        User barber;
        if (customerDb.isPresent() && barberDb.isPresent()){
            customer = customerDb.get();
            barber = barberDb.get();
        } else {
            throw new Exception();
            //TODO create an exception
        }
        Order order = new Order(null, LocalDateTime.now(), products, customer, barber,dateAppointment);
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(ObjectId id) {
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getAllOrdersByCustomer(String customerEmail) {
        List<Order> allOrders = orderRepository.findAll();
        return allOrders.stream().filter(order -> order.getCustomer().getEmail().equals(customerEmail)).toList();

    }

    public void deleteOrder(ObjectId id) {
        orderRepository.deleteById(id);
    }

}
