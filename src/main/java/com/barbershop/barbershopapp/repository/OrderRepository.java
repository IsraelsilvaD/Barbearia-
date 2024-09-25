package com.barbershop.barbershopapp.repository;

import com.barbershop.barbershopapp.domain.Order;
import com.barbershop.barbershopapp.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, ObjectId> {

}
