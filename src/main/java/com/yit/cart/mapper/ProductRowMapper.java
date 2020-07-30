package com.yit.cart.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yit.cart.bean.Product;

public class ProductRowMapper implements RowMapper<Product>  {

	
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

		Product p = new Product();
		p.setDescription(rs.getString("description"));
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setPrice(rs.getInt("price"));
		p.setInstock(rs.getInt("instock"));
		
		return p;
	}
	
}
