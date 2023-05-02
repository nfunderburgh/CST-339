package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.OrderModel;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class OrdersBusinessService implements OrdersBusinessInterface {

	@Autowired
	private DataAccessInterface<OrderModel> service;
	
	@Bean
	public void test() {
		System.out.println("Hello from OrdersBusinessService");
	}
	
	public List<OrderModel> getOrders() {
		
		/*ArrayList<OrderModel> orders = new ArrayList<OrderModel>();
		List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));
		orders.add(new OrderModel(1L, "00000002", "Product 2", 2.00f, 1));
		orders.add(new OrderModel(2L, "00000003", "Product 3", 3.00f, 1));
		orders.add(new OrderModel(3L, "00000004", "Product 4", 4.00f, 1));
		orders.add(new OrderModel(4L, "00000005", "Product 5", 5.00f, 1));
		orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));*/
		
		return service.findAll();
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
