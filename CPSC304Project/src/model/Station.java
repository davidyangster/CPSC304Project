package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Station {
	private final String station_name;
	private final String location;

	
	
	public Station(String station_name, String location) {

		this.station_name = station_name;
		this.location = location;
	}


	public String getStation_name() {
		return station_name;
	}


	public String getLocation() {
		return location;
	}


	
	public static Station fromResultSet(ResultSet rs) throws SQLException {
		String station_name = rs.getString("station_name");
		String location = rs.getString("location");
        return new Station(station_name,location);
    }
	
}
