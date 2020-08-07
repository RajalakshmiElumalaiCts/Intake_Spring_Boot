package com.intake.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "sales_item_id")
	private int salesItemId;
	
	@Column(name = "sales_item_name")
	private String salesItemName;
	 
	@Column(name = "sales_item_price")
	private float salesItemPrice;
	
	@Column(name = "sales_item_quantity")
	private int salesItemQuantity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
	
	public CartItem(){

    }
	
    public CartItem(int salesItemId, String salesItemName, float salesItemPrice, int salesItemQuantity, Cart cart) {
		super();
		this.salesItemId = salesItemId;
		this.salesItemName = salesItemName;
		this.salesItemPrice = salesItemPrice;
		this.salesItemQuantity = salesItemQuantity;
		this.cart = cart;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
    
}
