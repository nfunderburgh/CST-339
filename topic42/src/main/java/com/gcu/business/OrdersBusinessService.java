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
	
	public List<OrderModel> getOrders() {
		
		service.findAll();
		return null;
	}
	
	
	@PostConstruct
	public void init() {
		System.out.println("init() method");
	}
		
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy() method");
	}
	
}
