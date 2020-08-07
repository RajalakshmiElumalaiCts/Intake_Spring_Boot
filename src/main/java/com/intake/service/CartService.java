package com.intake.service;

import java.util.List;

import com.intake.model.db.Cart;
import com.intake.model.db.CartItem;

public interface CartService {

	CartItem addCartItem(CartItem cartItem);
	
	CartItem getCartItem(int cartItemId);
	
	Cart getCart(int cartId);
	
	Cart addCart(Cart cart);
	
	void deleteCart(int id);
	
	void deleteCartItem(int id, int cartId);
	
	CartItem updateCartItemQuantity(int id, int newQuantity);
	
	CartItem getCartItemBySalesItemIdAndCartId(int salesItemId, int cartId);

	List<CartItem> getAllCartItems(int cartId);
	
}
