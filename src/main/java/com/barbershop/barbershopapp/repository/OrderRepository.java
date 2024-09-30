package com.trimtime.app.repository;

import com.trimtime.app.domain.Order;
import com.trimtime.app.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, ObjectId> {

}
