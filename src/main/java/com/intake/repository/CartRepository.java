package com.intake.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intake.model.db.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {	
	

}
