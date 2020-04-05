package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ticket {
	private final int ticket_no;
	private final int pid;
	private final String class_;


	
	public Ticket(int ticket_no, String class_, int pid) {
		this.ticket_no = ticket_no;
		this.class_ = class_;
		this.pid = pid;
	}
	

	
	public int getTicket_no() {
		return ticket_no;
	}


	public String getClass_() {
		return class_;
	}


	public int getPid() {
		return pid;
	}

	public static Ticket fromResultSet(ResultSet rs) throws SQLException {
		int ticket_no =  rs.getInt("ticket_no");
        String class_ = rs.getString("class");
		int pid = rs.getInt("pid");
		
        return new Ticket(ticket_no, class_, pid);
    }

}
