package com.gcu.business;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.gcu.model.OrderModel;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

	@Bean
	public void test() {
		System.out.println("Hello from the AnotherOrdersBusinessService");
	}
	
	public ArrayList<OrderModel> getOrders() {
		
		ArrayList<OrderModel> orders = new ArrayList<OrderModel>();
		//List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel("0", "00000001", "Product 1", 1.00f, 1));
		orders.add(new OrderModel("1", "00000002", "Product 2", 2.00f, 1));
		orders.add(new OrderModel("2", "00000003", "Product 3", 3.00f, 1));
		orders.add(new OrderModel("3", "00000004", "Product 4", 4.00f, 1));
		orders.add(new OrderModel("4", "00000005", "Product 5", 5.00f, 1));
		//orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));
		
		
		return orders;
	}

	@PostConstruct
	public void init() {
		System.out.println("Another init() method");
	}
		
	@PreDestroy
	public void destroy() {
		System.out.println("Another Destroy() method");
	}

	@Override
	public OrderModel getOrderById(String id) {
		return null;
	}
}
