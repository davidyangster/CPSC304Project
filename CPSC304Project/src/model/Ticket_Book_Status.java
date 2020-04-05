package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ticket_Book_Status {

	private final int ticket_no;
	private final int pid;
	private final String book_status;

	
	public Ticket_Book_Status(int ticket_no, int pid, String book_status) {
		this.ticket_no = ticket_no;
		this.pid = pid;
		this.book_status = book_status;
	}


	public int getTicket_no() {
		return ticket_no;
	}



	public int getPid() {
		return pid;
	}



	public String getBook_status() {
		return book_status;
	}



	public static Ticket_Book_Status fromResultSet(ResultSet rs) throws SQLException {
		int ticket_no =  rs.getInt("ticket_no");
        int pid = rs.getInt("pid");
		String book_status = rs.getString("book_status");
		
        return new Ticket_Book_Status(ticket_no, pid, book_status);
    }
	
}
