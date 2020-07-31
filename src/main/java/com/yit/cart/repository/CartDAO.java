package com.yit.cart.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yit.cart.bean.Cart;
import com.yit.cart.bean.Product;

@Repository
public interface CartDAO {

	List<Cart> getCarts();
	int insertCart(Cart cart);
	int deleteItem(Cart cart);
	int countItem(Cart cart);
	
	
}
