package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Class_ {

	private final String class_;
	private final int price;

	
	public Class_(int price, String class_) {
		this.price = price;
		this.class_ = class_;
	}


	public int getPrice() {
		return price;
	}


	public String get_class_() {
		return class_;
	}



	public static Class_ fromResultSet(ResultSet rs) throws SQLException {
		int price =  rs.getInt("price");
		String class_ = rs.getString("class");
		
        return new Class_(price, class_);
    }
	
}
