package com.yit.cart.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yit.cart.bean.Product;

@Repository
public interface ProductDAO {

	List<Product> getProducts();
	
	
}
