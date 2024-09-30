package com.trimtime.app.api;

import com.timtime.app.domain.CreateOrderRequest;
import com.trimtime.app.domain.Order;
import com.trimtime.app.domain.User;
import com.trimtime.app.service.OrderService;
import com.trimtime.app.domain.Product;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")  // Base URL for the Order endpoints
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 1. Create a new order
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request) throws Exception {
        List<Product> products = request.getProducts();
        Long customerId = request.getCustomerId();
        Long barberId = request.getBarberId();
        LocalDate dateAppointment = request.getDateAppointment();

        Order newOrder = orderService.createOrder(products, customerId, barberId, dateAppointment);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    // 2. Get all orders
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // 3. Get order by ID
    @GetMapping("customer/{customerEmail}")
    public ResponseEntity<List<Order>> getOrderByCustomer(@PathVariable String customerEmail) {
        List<Order> orders = orderService.getAllOrdersByCustomer(customerEmail);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // 3. Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable ObjectId id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 5. Delete an order by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable ObjectId id) {
        Optional<Order> existingOrder = orderService.getOrderById(id);
        if (existingOrder.isPresent()) {
            orderService.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
