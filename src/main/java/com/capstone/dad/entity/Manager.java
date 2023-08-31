package com.capstone.dad.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "mitenLogin")
public class Manager {

	@Id
	private String  id;

    private String username;

    private String password;
	public String  getId() {
		return id;
	}
	public void setId(String  id) {
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
	public Manager(String  id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Manager(String  id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	public Manager(String  id) {
		super();
		this.id = id;
	}
	public Manager() {
		super();
	}
	@Override
	public String toString() {
		return "login [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
