package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ticket_Seat {
	private final int ticket_no;
	private final int train_id;
	private final int row;
	private final int seat_no;

	
	public Ticket_Seat(int ticket_no, int row, int seat_no, int train_id) {
		this.ticket_no = ticket_no;
		this.row = row;
		this.seat_no = seat_no;
		this.train_id = train_id;
	}
	

	
	public int getTicket_no() {
		return ticket_no;
	}


	public int getRow() {
		return row;
	}


	public int getSeat_no() {
		return seat_no;
	}


	public int getTrain_id() {
		return train_id;
	}

	public static Ticket_Seat fromResultSet(ResultSet rs) throws SQLException {
		int ticket_no =  rs.getInt("ticket_no");
		int row = rs.getInt("row");
		int seat_no = rs.getInt("seat_no");
		int train_id = rs.getInt("train_id");
		
        return new Ticket_Seat(ticket_no, row, seat_no, train_id);
    }

}
