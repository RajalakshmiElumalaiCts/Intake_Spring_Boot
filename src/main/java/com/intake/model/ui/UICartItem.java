package com.intake.model.ui;

public class UICartItem {
	
	private int id;
	
	private int salesItemId;
	
	private String salesItemName;
	 
	private float salesItemPrice;
	
	private int salesItemQuantity;
	
    private int cartId;

	public UICartItem(int id, int salesItemId, String salesItemName, float salesItemPrice, int salesItemQuantity,
			int cartId) {
		super();
		this.id = id;
		this.salesItemId = salesItemId;
		this.salesItemName = salesItemName;
		this.salesItemPrice = salesItemPrice;
		this.salesItemQuantity = salesItemQuantity;
		this.cartId = cartId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalesItemId() {
		return salesItemId;
	}

	public void setSalesItemId(int salesItemId) {
		this.salesItemId = salesItemId;
	}

	public String getSalesItemName() {
		return salesItemName;
	}

	public void setSalesItemName(String salesItemName) {
		this.salesItemName = salesItemName;
	}

	public float getSalesItemPrice() {
		return salesItemPrice;
	}

	public void setSalesItemPrice(float salesItemPrice) {
		this.salesItemPrice = salesItemPrice;
	}

	public int getSalesItemQuantity() {
		return salesItemQuantity;
	}

	public void setSalesItemQuantity(int salesItemQuantity) {
		this.salesItemQuantity = salesItemQuantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
    
	

}
