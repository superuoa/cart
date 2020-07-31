package com.yit.cart.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yit.cart.bean.Cart;
import com.yit.cart.bean.Product;
import com.yit.cart.util.MapperUtil;

public class CartRowMapper implements RowMapper<Cart>  {

	
	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {

		Cart c = new Cart();
		c.setId(rs.getInt("id"));
		c.setProduct_id(rs.getInt("product_id"));
	
		if(MapperUtil.isThere(rs, "p.id")) {
			Product p = new Product();
			p.setDescription(rs.getString("description"));
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			p.setInstock(rs.getInt("instock"));
			c.setProduct(p);
		}
		
		if(MapperUtil.isThere(rs, "unit")) {
			c.setUnit(rs.getInt("unit"));
		}
		if(MapperUtil.isThere(rs, "amount")) {
			c.setAmount(rs.getInt("amount"));
		}
		
		return c;
	}
	
}
