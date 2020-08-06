package com.intake.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartItem {
	
	@Id
	private int id;
	
	@Column(name = "sales_item_id")
	private int salesItemId;
	
	@Column(name = "sales_item_name")
	private int salesItemName;
	 
	@Column(name = "sales_item_price")
	private int salesItemPrice;
	
	@Column(name = "sales_item_quantity")
	private int salesItemQuantity;
	
	public CartItem(){

    }
	
    public CartItem(int salesItemId, int salesItemName, int salesItemPrice, int salesItemQuantity) {
		super();
		this.salesItemId = salesItemId;
		this.salesItemName = salesItemName;
		this.salesItemPrice = salesItemPrice;
		this.salesItemQuantity = salesItemQuantity;
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

	public int getSalesItemName() {
		return salesItemName;
	}

	public void setSalesItemName(int salesItemName) {
		this.salesItemName = salesItemName;
	}

	public int getSalesItemPrice() {
		return salesItemPrice;
	}

	public void setSalesItemPrice(int salesItemPrice) {
		this.salesItemPrice = salesItemPrice;
	}

	public int getSalesItemQuantity() {
		return salesItemQuantity;
	}

	public void setSalesItemQuantity(int salesItemQuantity) {
		this.salesItemQuantity = salesItemQuantity;
	}

    
}
