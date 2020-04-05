package model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Passenger {
	private final int pid;
	private final String first_name;
	private final String last_name;
	
	public Passenger(int pid, String last_name, String first_name ) {
		this.pid = pid;
		this.last_name = last_name;
		this.first_name = first_name;
	}

	public int getPid() {
		return pid;
	}

	public String getLast_name() {
		return last_name;
	}
	
	public String getFirst_name() {
		return first_name;
	}

	
	public static Passenger fromResultSet(ResultSet rs) throws SQLException {
        int pid = rs.getInt("pid");
        String last_name = rs.getString("last_name");
        String first_name = rs.getString("first_name");
        return new Passenger(pid, last_name, first_name);
    }
}
