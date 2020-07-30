package com.yit.cart.bean;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Cart {

	int id;
	int product_id;
	int discount;
	Product product;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public static List<Cart> buildJsonToCallsObject(String json){

		Gson gson = new Gson();
		
		TypeToken<List<Cart>> token = new TypeToken<List<Cart>>() {};
		List<Cart> cList = gson.fromJson(json, token.getType());
		
		
		return cList;
		
	}
	
	public static Cart buildJsonToObject(String json){

		Gson gson = new Gson();

		Cart c = gson.fromJson(json, Cart.class);
		
		
		return c;
		
	}
	
}
