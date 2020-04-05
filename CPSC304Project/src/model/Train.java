package model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Train {
	private final int train_id;
	private final String train_type;
	private final String train_name;
	private final int status_id;
	
	public Train(int train_id, String train_name, String train_type, int status_id) {
		this.train_id = train_id;
		this.train_name = train_name;
		this.train_type = train_type;
		this.status_id = status_id;
	}

	public int getTrain_id() {
		return train_id;
	}

	public String getTrain_name() {
		return train_name;
	}
	

	public String getTrain_type() {
		return train_type;
	}
	
	public int getStatus_id() {
		return status_id;
	}

	
	public static Train fromResultSet(ResultSet rs) throws SQLException {
        int train_id = rs.getInt("train_id");
        String train_name = rs.getString("train_name");
        String train_type = rs.getString("train_type");
        int status_id = rs.getInt("status_id");
        return new Train(train_id, train_name, train_type, status_id);
    }
}
