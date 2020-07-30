package com.yit.cart.repository;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yit.cart.bean.Cart;
import com.yit.cart.bean.Product;
import com.yit.cart.mapper.CartRowMapper;
import com.yit.cart.mapper.ProductRowMapper;

@Repository
public class CartDAOImpl implements CartDAO{

	NamedParameterJdbcTemplate template;

	public CartDAOImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
	}
	
	
	@Override
	public List<Cart> getCarts() {
		MapSqlParameterSource param = new MapSqlParameterSource();

		List<Cart> mm = template.query("select * from cart c"
										+" INNER JOIN product p on p.id = c.product_id"
										, param,new CartRowMapper());
		
		return mm;
	}

	@Override
	public int insertCart(Cart cart) {
		MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("product_id",cart.getProduct_id());
        param.addValue("discount", cart.getDiscount());
        param.addValue("date", new Date());
        
        int mm = template.update("insert into cart(product_id,discount,date) "
        		+ "values(:product_id,:discount,:date)", param);
		
		return mm;
	}

}
