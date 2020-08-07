package com.intake.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intake.model.db.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	 	Optional<CartItem> findBySalesItemIdAndCartId(int salesItemId, int cartId);

		List<CartItem> findAllByCartId( int cartId);
	 	
}
