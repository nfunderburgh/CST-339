package com.gcu;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.OrdersBusinessService;

@EnableMongoRepositories
@Configuration
public class SpringConfig {
	
	@Primary
	@Bean(name="OrdersBusinessService")
	public OrdersBusinessInterface getOrdersBusiness()
	{
		return new OrdersBusinessService();
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
