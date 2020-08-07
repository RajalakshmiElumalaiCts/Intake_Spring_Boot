package com.intake.controller.api.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intake.model.db.Cart;
import com.intake.model.db.CartItem;
import com.intake.model.db.UserProfile;
import com.intake.model.ui.CartObject;
import com.intake.model.ui.response.CartResponse;
import com.intake.service.CartService;
import com.intake.service.UserService;

@CrossOrigin
//@CrossOrigin(origins = "http://192.168.1.46:8081/")
@RestController
@RequestMapping("/cart_api")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@RequestMapping(value = "/add_item_to_cart", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public CartResponse addItemToCart(@RequestBody CartObject cartObject) {
		
		System.out.println("cartObject-------------->"+cartObject);
		Cart cart = null;
		UserProfile user = userService.getUser(cartObject.getUserId());
		
		if(cartObject.getCartId() == null) {
			//creating new cart
			Cart newcart = new Cart(user, cartObject.getJwt(), "pending");
			cart = cartService.addCart(newcart);
			
			cart = cartService.getCart(cart.getId());
			//adding first sales item to cart
			CartItem cartItem = new CartItem(cartObject.getSalesItemId(), cartObject.getName(), 
					cartObject.getPrice(),cartObject.getQuantity(), cart);			
			
			cartItem = cartService.addCartItem(cartItem);
		}else {
			cart = cartService.getCart(cartObject.getCartId());
			
			//check the cart has existing item
			CartItem cartItem = null;
			cartItem = cartService.getCartItemBySalesItemIdAndCartId(cartObject.getSalesItemId(), cart.getId());
			
			if(cartItem == null) {
				//adding new item to existing cart
				cartItem = new CartItem(cartObject.getSalesItemId(), cartObject.getName(), 
						cartObject.getPrice(),cartObject.getQuantity(), cart);
			}
			else {
				cartItem.setSalesItemName(cartObject.getName());
				cartItem.setSalesItemPrice(cartObject.getPrice());
				cartItem.setSalesItemQuantity(cartObject.getQuantity());
			}
			cartItem = cartService.addCartItem(cartItem);
			
		}
		CartResponse response = new CartResponse(cart.getId());
		
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/remove_item_from_cart", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String removeItemFromCart(@RequestBody CartObject cartObject) {
		
		if(cartObject.getSalesItemId() != null) {
			cartService.deleteCartItem(cartObject.getSalesItemId(), cartObject.getCartId());
			return "{  \"status\" : \"Success\" }";
		}
		
		return "{  \"status\" : \"Failed\" }";
		
	}
	
}
