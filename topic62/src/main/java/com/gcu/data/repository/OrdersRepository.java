package com.gcu.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.data.entity.OrderEntity;

@Repository 
public interface OrdersRepository extends MongoRepository<OrderEntity, String>{

	public OrderEntity getOrderById(String id);
}
