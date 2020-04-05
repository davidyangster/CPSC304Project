package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Train_Operates_On_Route {
	private final int train_id;
	private final int route_id;

	
	public Train_Operates_On_Route(int train_id, int route_id) {
		this.train_id = train_id;
		this.route_id = route_id;
	}


	public int getTrain_id() {
		return train_id;
	}


	public int getRoute_id() {
		return route_id;
	}


	public static Train_Operates_On_Route fromResultSet(ResultSet rs) throws SQLException {
		int train_id = rs.getInt("train_id");
		int route_id = rs.getInt("route_id");
		
        return new Train_Operates_On_Route(train_id, route_id);
    }
}
