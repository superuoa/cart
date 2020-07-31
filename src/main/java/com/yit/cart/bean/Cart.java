package com.yit.cart.bean;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Cart {

	int id;
	int product_id;
	Product product;
	int unit;
	int amount;
	
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
