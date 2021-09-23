package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //will turn the User class into a table
public class User {
	@Id //Will turn name into the primary key
	private String name;
	private String password;
	private String email;
	private String city;
	public User(String name, String password, String email, String city) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name2, String password2) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", email=" + email + ", city=" + city + "]";
	}
	
}
