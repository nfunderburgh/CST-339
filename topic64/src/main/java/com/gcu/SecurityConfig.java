package com.gcu;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig {

	protected void securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests((requests) -> requests
			.requestMatchers("/","/login**","/callback/","/error**").permitAll()
			.anyRequest().authenticated());
	}
}
