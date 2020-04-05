package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class First_Class {
	private final int train_id;
	private final int row;
	private final int seat_no;
	private final String meal_option;
	private final String drink_option;
	private final String entertainment;
	

	public First_Class(int train_id, int row, int seat_no, String meal_option, String drink_option, String entertainment) {
		this.train_id = train_id;
		this.row = row;
		this.seat_no = seat_no;
		this.meal_option = meal_option;
		this.drink_option = drink_option;
		this.entertainment = entertainment;
	}

	public int getTrain_id() {
		return train_id;
	}

	public int getRow() {
		return row;
	}


	public int getSeat_no() {
		return seat_no;
	}


	public String getMeal_option() {
		return meal_option;
	}


	public String getDrink_option() {
		return drink_option;
	}


	public String getEntertainment() {
		return entertainment;
	}


	public static First_Class fromResultSet(ResultSet rs) throws SQLException {
		int train_id = rs.getInt("train_id");
		int row = rs.getInt("row");
		int seat_no = rs.getInt("seat_no");
		String meal_option  = rs.getString("meal_option");
		String drink_option  = rs.getString("drink_option");
		String entertainment  = rs.getString("entertainment");
		
        return new First_Class(train_id, row, seat_no, meal_option, drink_option, entertainment);
    }
}
