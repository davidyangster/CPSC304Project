package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class Arrives {
	private final int train_id;
	private final String station_name;
	private final String location;
	private final Timestamp sched_time;
	private final Timestamp actual_time;

	
	public Arrives(int train_id, String station_name, String location, Timestamp sched_time, Timestamp actual_time) {
		super();
		this.train_id = train_id;
		this.station_name = station_name;
		this.location = location;
		this.sched_time = sched_time;
		this.actual_time = actual_time;
	}


	public int getTrain_id() {
		return train_id;
	}



	public String getStation_name() {
		return station_name;
	}



	public String getLocation() {
		return location;
	}



	public Timestamp getSched_time() {
		return sched_time;
	}



	public Timestamp getActual_time() {
		return actual_time;
	}



	public static Arrives fromResultSet(ResultSet rs) throws SQLException {
        int train_id = rs.getInt("train_id");
        String location = rs.getString("location");
        String station_name = rs.getString("station_name");
        Timestamp sched_time = rs.getTimestamp("sched_time");
        Timestamp actual_time = rs.getTimestamp("actual_time");
        return new Arrives(train_id, location, station_name, sched_time, actual_time );
    }
}
