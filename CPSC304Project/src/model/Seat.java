package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Seat {
	private final int train_id;
	private final int row;
	private final int seat_no;

	
	public Seat(int train_id, int row, int seat_no) {
		this.train_id = train_id;
		this.row = row;
		this.seat_no = seat_no;
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




	public static Seat fromResultSet(ResultSet rs) throws SQLException {
        int train_id = rs.getInt("train_id");
		int row = rs.getInt("row");
		int seat_no = rs.getInt("seat_no");
		
        return new Seat(train_id, row, seat_no);
    }
}
