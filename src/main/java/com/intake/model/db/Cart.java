package com.intake.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	private int id;
	
	@Column(name ="user_id")
	private int userId;
	
	@Column(name ="jwt")
	private String jwt;
	
	@Column(name ="status")
	private String status;	
	
	public Cart() {
		
	}

	public Cart(int userId, String jwt, String status) {
		super();
		this.userId = userId;
		this.jwt = jwt;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
