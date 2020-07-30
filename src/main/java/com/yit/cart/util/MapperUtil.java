package com.yit.cart.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUtil {

	
	public static boolean isThere(ResultSet rs, String column) {
		  try {
		    rs.findColumn(column);
		    return true;
		  } catch (SQLException sqlex) {
		    //System.out.println("column doesn't exist " + column);
		  }
		  return false;
	}
	
}
