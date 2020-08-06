package com.intake.service;

import com.intake.model.db.Cart;
import com.intake.model.db.CartItem;

public interface CartService {

	void addCartItem();
	CartItem getCartItem();
	Cart getCart();
	void addCart();
	
}
