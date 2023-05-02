package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class OrdersBusinessService implements OrdersBusinessInterface {

	@Autowired
	private OrdersDataService service;
	
	@Bean
	public void test() {
		System.out.println("Hello from OrdersBusinessService");
	}
	
	@Override
	public List<OrderModel> getOrders() {
		
		List<OrderEntity> ordersEntity = service.findAll();
		
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for(OrderEntity entity: ordersEntity) {
			
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(),entity.getProductName(),entity.getPrice(), entity.getQuantity()));
		}
		
		return ordersDomain;
	}
	
	
	@PostConstruct
	public void init() {
		System.out.println("init() method");
	}
		
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy() method");
	}

	@Override
	public OrderModel getOrderById(String id) {
		
		OrderEntity orderEntity= service.findById(id);
		
		return new OrderModel(orderEntity.getId(), orderEntity.getOrderNo(), orderEntity.getProductName(), orderEntity.getPrice(), orderEntity.getQuantity());
	}
	
}
