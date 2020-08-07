package com.intake.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intake.model.db.Cart;
import com.intake.model.db.CartItem;
import com.intake.repository.CartItemRepository;
import com.intake.repository.CartRepository;
import com.intake.service.CartService;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public CartItem addCartItem(CartItem cartItem) {
		CartItem savedCartItem = cartItemRepository.saveAndFlush(cartItem);
		return savedCartItem;
	}

	@Override
	public CartItem getCartItem(int id) {
		Optional<CartItem> returnOption = cartItemRepository.findById(id);
		return returnOption.get();
	}

	@Override
	public Cart getCart(int id) {
		Optional<Cart> returnOption = cartRepository.findById(id);
		return returnOption.get();
	}

	@Override
	public Cart addCart(Cart cart) {
		Cart savedCart = cartRepository.save(cart);
		cartRepository.flush();
		return savedCart;
	}

	@Override
	public void deleteCart(int id) {
		cartRepository.deleteById(id);
	}

	@Override
	public void deleteCartItem(int salesItemId, int cartId) {
		Optional<CartItem> option=  cartItemRepository.findBySalesItemIdAndCartId(salesItemId, cartId);
		if(option.isPresent()) {
			cartItemRepository.deleteById(option.get().getId());	
		}
			
	}

	@Override
	public CartItem updateCartItemQuantity(int id, int newQuantity) {
		Optional<CartItem> option = cartItemRepository.findById(id);
		CartItem updatedCartItem = null;
		if(option.isPresent()) {
			updatedCartItem = option.get();
			updatedCartItem.setSalesItemQuantity(newQuantity);
			updatedCartItem = cartItemRepository.save(updatedCartItem);			
		}
		return updatedCartItem;
	}

	@Override
	public CartItem getCartItemBySalesItemIdAndCartId(int salesItemId, int cartId) {
		Optional<CartItem> option=  cartItemRepository.findBySalesItemIdAndCartId(salesItemId, cartId);
		if(option.isPresent()) {
			return option.get();	
		}
		return null;
	}

}
