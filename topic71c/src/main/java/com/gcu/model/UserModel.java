package com.gcu.model;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public class UserModel {

	private String id;
	private String username;
	private String password;
	
	public UserModel() {
		
		this.setId("");
		this.setUsername("");
		this.setPassword("");
	}
	
	public UserModel(String id, String username, String password) {
		
		super();
		this.setId(id);
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
