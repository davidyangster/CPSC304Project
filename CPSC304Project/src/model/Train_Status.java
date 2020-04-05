package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Train_Status {
	private final int status_id;
	private final int book_seats;
	private final int max_seats;
	private final int avail_seats;
	private final int waiting;


	public Train_Status(int status_id, int book_seats, int max_seats, int avail_seats, int waiting) {
		super();
		this.status_id = status_id;
		this.book_seats = book_seats;
		this.max_seats = max_seats;
		this.avail_seats = avail_seats;
		this.waiting = waiting;
	}


	public int getStatus_id() {
		return status_id;
	}


	public int getBook_seats() {
		return book_seats;
	}


	public int getMax_seats() {
		return max_seats;
	}


	public int getAvail_seats() {
		return avail_seats;
	}

	
	public int getWaiting() {
		return waiting;
	}


	public static Train_Status fromResultSet(ResultSet rs) throws SQLException {
		int status_id =  rs.getInt("status_id");
        int book_seats = rs.getInt("book_seats");
		int max_seats = rs.getInt("max_seats");
		int avail_seats = rs.getInt("avail_seats");
		int waiting = rs.getInt("waiting");
		
        return new Train_Status(status_id, book_seats, max_seats, avail_seats, waiting);
    }
}
