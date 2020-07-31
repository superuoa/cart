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

		List<Cart> mm = template.query(
				"select *,count(p.id) as unit,sum(p.price) as amount from cart c" + 
						" INNER JOIN product p on p.id = c.product_id" + 
						" GROUP BY p.id"
										, param,new CartRowMapper());
		
		return mm;
	}

	@Override
	public int insertCart(Cart cart) {
		MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("product_id",cart.getProduct_id());
        param.addValue("date", new Date());
        
        int mm = template.update("insert into cart(product_id,date) "
        		+ "values(:product_id,:date)", param);
		
		return mm;
	}


	@Override
	public int deleteItem(Cart cart) {
		MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("product_id",cart.getProduct_id());
        int mm = template.update(
        					"DELETE from cart WHERE product_id=:product_id "
        					+ " order by id desc limit 1", param);
		
		return mm;
	}


	@Override
	public int countItem(Cart cart) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("product_id",cart.getProduct_id());
		
        int mm = template.queryForObject("select count(*) from cart WHERE product_id=:product_id",param, Integer.class);

		return mm;
	}

}
