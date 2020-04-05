package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Route_Name {

	private final int route_id;
	private final String route_name;

	
	public Route_Name(int route_id, String route_name) {
		this.route_id = route_id;
		this.route_name = route_name;
	}


	public int getRoute_id() {
		return route_id;
	}


	public String getRoute_name() {
		return route_name;
	}



	public static Route_Name fromResultSet(ResultSet rs) throws SQLException {
		int route_id =  rs.getInt("route_id");
		String route_name = rs.getString("class");
		
        return new Route_Name(route_id, route_name);
    }
	
}
