package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.business.UserBusinessService;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserBusinessService service;
	
	String plainTextPassword = "1234567890";
	String encoded = new BCryptPasswordEncoder().encode(plainTextPassword);
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
		.userDetailsService(service)
		.passwordEncoder(passwordEncoder);
		
		System.out.println("The password that was encoded was " + encoded);
	}
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        	http.httpBasic().and()
                .authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/", "/images/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                                .loginPage("/login")
                                .defaultSuccessUrl("/orders/display", true)
                                .permitAll()
                )
                .logout((logout) -> logout.permitAll()

                );
			
			return http.build();
	}
}


