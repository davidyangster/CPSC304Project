package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Economy {
	private final int row;
	private final int seat_no;

	
	public Economy(int row, int seat_no) {

		this.row = row;
		this.seat_no = seat_no;
	}


	public int getRow() {
		return row;
	}


	public int getSeat_no() {
		return seat_no;
	}




	public static Economy fromResultSet(ResultSet rs) throws SQLException {
		int row = rs.getInt("row");
		int seat_no = rs.getInt("seat_no");
		
        return new Economy(row, seat_no);
    }
}
