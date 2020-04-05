package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Route_Details {
	private final String route_name;
	private final String start_station_name;
	private final String start_station_location;
	private final String end_station_name;
	private final String end_station_location;
	
	
	public Route_Details(String route_name, String start_station_name, String start_station_location,
			String end_station_name, String end_station_location) {

		this.route_name = route_name;
		this.start_station_name = start_station_name;
		this.start_station_location = start_station_location;
		this.end_station_name = end_station_name;
		this.end_station_location = end_station_location;
	}


	public String getRoute_name() {
		return route_name;
	}


	public String getStart_station_name() {
		return start_station_name;
	}


	public String getStart_station_location() {
		return start_station_location;
	}


	public String getEnd_station_name() {
		return end_station_name;
	}


	public String getEnd_station_location() {
		return end_station_location;
	}
	public static Route_Details fromResultSet(ResultSet rs) throws SQLException {
		String route_name				= rs.getString("route_name");             
		String start_station_name		= rs.getString("start_station_name");     
		String start_station_location	= rs.getString("start_station_location"); 
		String end_station_name			= rs.getString("end_station_name");       
		String end_station_location		= rs.getString("end_station_location");   
		
		return new Route_Details(route_name, start_station_name, start_station_location,
			 end_station_name, end_station_location);
	}
	                            
}
