package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Station_On_Route {

	private final int route_id;
	private final String station_name;
	private final String location;

	
	public Station_On_Route(int route_id, String station_name, String location) {
		this.route_id = route_id;
		this.station_name = station_name;
		this.location = location;
	}


	public int getRoute_id() {
		return route_id;
	}


	public String getStation_name() {
		return station_name;
	}
	
	public String getLocation() {
		return location;
	}


	public static Station_On_Route fromResultSet(ResultSet rs) throws SQLException {
		int route_id =  rs.getInt("route_id");
		String station_name = rs.getString("class");
		String location = rs.getString("location");
		
        return new Station_On_Route(route_id, station_name, location);
    }
	
}
