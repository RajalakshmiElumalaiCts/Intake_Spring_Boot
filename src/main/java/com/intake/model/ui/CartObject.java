package com.intake.model.ui;

import lombok.Data;

@Data
public class CartObject {
		
	private Integer userId;
	private Integer SalesItemId;
	private String Name;
	private Float Price;
	private Integer Quantity;
	private Integer cartId;
	private String jwt;
	
	public CartObject(Integer userId, Integer salesItemId, String name, Float price, Integer quantity, Integer cartId,
			String jwt) {
		super();
		this.userId = userId;
		SalesItemId = salesItemId;
		Name = name;
		Price = price;
		Quantity = quantity;
		this.cartId = cartId;
		this.jwt = jwt;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSalesItemId() {
		return SalesItemId;
	}

	public void setSalesItemId(Integer salesItemId) {
		SalesItemId = salesItemId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Float getPrice() {
		return Price;
	}

	public void setPrice(Float price) {
		Price = price;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	@Override
	public String toString() {
		return "CartObject [userId=" + userId + ", SalesItemId=" + SalesItemId + ", Name=" + Name + ", Price=" + Price
				+ ", Quantity=" + Quantity + ", cartId=" + cartId + ", jwt=" + jwt + "]";
	}
	
	
	

}
