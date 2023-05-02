package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.*;
import com.gcu.model.OrderModel;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersBusinessInterface service;
	
	@GetMapping("/display")
	public String display(Model model) {
		
		List<OrderModel> orders = service.getOrders();
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", orders);
		return "orders";	
	}
}
