package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;

import controller.QueryResult;
import model.*;

/**
 * This class handles all database related transactions
 */
public class DatabaseConnectionHandler implements Queries{
	// Use this version of the ORACLE_URL if you are running the code off of the server
//	private static final String ORACLE_URL = "jdbc:oracle:thin:@dbhost.students.cs.ubc.ca:1522:stu";
	// Use this version of the ORACLE_URL if you are tunneling into the undergrad servers
	private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
	private static final String EXCEPTION_TAG = "[EXCEPTION]";
	private static final String WARNING_TAG = "[WARNING]";
	
	private Connection connection = null;
	
	public DatabaseConnectionHandler() {
		try {
			// Load the Oracle JDBC driver
			// Note that the path could change for new drivers
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}
	
	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	public void deleteBranch(int branchId) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM branch WHERE branch_id = ?");
			ps.setInt(1, branchId);
			
			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " Branch " + branchId + " does not exist!");
			}
			
			connection.commit();
	
			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}
	
	public void insertBranch(BranchModel model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO branch VALUES (?,?,?,?,?)");
			ps.setInt(1, model.getId());
			ps.setString(2, model.getName());
			ps.setString(3, model.getAddress());
			ps.setString(4, model.getCity());
			if (model.getPhoneNumber() == 0) {
				ps.setNull(5, java.sql.Types.INTEGER);
			} else {
				ps.setInt(5, model.getPhoneNumber());
			}

			ps.executeUpdate();
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}
	
	// Query 1: Insert Passenger
	public QueryResult addPassenger(Passenger passenger) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Passenger VALUES (?,?,?)");
			ps.setInt(1, passenger.getPid());
			ps.setString(2, passenger.getLast_name());
			ps.setString(3, passenger.getFirst_name());
			ps.executeUpdate();
			connection.commit();

			ps.close();
			return new QueryResult(true,"success");
		} catch (SQLException e) {
			rollbackConnection();
			return new QueryResult(false, (EXCEPTION_TAG + " " + e.getMessage()));
		}
	}
	
	// Query 2: Buy Ticket
		public QueryResult buyTicket(Ticket ticket) {
			try {
				PreparedStatement ps = connection.prepareStatement("INSERT INTO Ticket VALUES (?,?,?)");
				ps.setInt(1, ticket.getTicket_no());
				ps.setInt(2, ticket.getPid());
				ps.setString(3, ticket.getClass_());
				ps.executeUpdate();
				connection.commit();
				
				set_Book_Status(ticket);
				
				ps.close();
				return new QueryResult(true,"success");
			} catch (SQLException e) {
				rollbackConnection();
				return new QueryResult(false, (EXCEPTION_TAG + " " + e.getMessage()));
			}
		}
		
		//Insert in Book
		public void set_Book_Status(Ticket ticket){
			try {
				PreparedStatement ps = connection.prepareStatement("INSERT INTO Ticket_book_status VALUES (?,?,?)");
			
				ps.setInt(1, ticket.getTicket_no());
				ps.setInt(2, ticket.getPid());
				ps.setString(3, "Pending");
				ps.executeUpdate();
				connection.commit();
				
				ps.close();
			} catch (SQLException e) {
				rollbackConnection();
				System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			}
		}
		
		@Override
		public QueryResult assignSeats(Ticket_Seat ts) {
			try {
				PreparedStatement ps = connection.prepareStatement("INSERT INTO Ticket_Seat VALUES (?,?,?,?)");
				ps.setInt(1, ts.getTicket_no());
				ps.setInt(2, ts.getRow());
				ps.setInt(3, ts.getSeat_no());
				ps.setInt(4, ts.getTrain_id());
				ps.executeUpdate();
				connection.commit();
				
				ps = connection.prepareStatement("UPDATE Train_Status SET waitlist = waitlist + 1 WHERE avail_seats = 0"
						+ "AND status_id IN (SELECT T.status_id FROM Train T WHERE train_id = ?");
				ps.setInt(1, ts.getTrain_id());
				ps.executeUpdate();
				connection.commit();
				
				ps = connection.prepareStatement("UPDATE Train_Status SET booked_seats = max_seats WHERE booked_seats = max_seats - 1"
						+ "AND status_id IN (SELECT T.status_id FROM Train T WHERE train_id = ?");
				ps.setInt(1, ts.getTrain_id());
				ps.executeUpdate();
				connection.commit();
				
				ps = connection.prepareStatement("UPDATE Train_Status SET booked_seats = booked_seats + 1 WHERE booked_seats < max_seats"
						+ "AND status_id IN (SELECT T.status_id FROM Train T WHERE train_id = ?");
				ps.setInt(1, ts.getTrain_id());
				ps.executeUpdate();
				connection.commit();
				
				ps = connection.prepareStatement("UPDATE Train_Status SET avail_seats = avail_seats - 1 WHERE avail_seats > 0"
						+ "AND status_id IN (SELECT T.status_id FROM Train T WHERE train_id = ?");
				ps.setInt(1, ts.getTrain_id());
				ps.executeUpdate();
				
				
				connection.commit();
				
				ps.close();
				return new QueryResult(true,"success");
			} catch (SQLException e) {
				rollbackConnection();
				return new QueryResult(false, (EXCEPTION_TAG + " " + e.getMessage()));
			}
		}

		@Override
		public QueryResult update_book_status(Ticket_Book_Status tbs) {
			try {
				PreparedStatement ps = connection.prepareStatement("Update Ticket_book_status SET book_status = ? WHERE ticket_no = ? AND pid = ?");
			
				ps.setString(1, tbs.getBook_status());
				ps.setInt(2, tbs.getTicket_no());
				ps.setInt(3, tbs.getPid());
				
				ps.executeUpdate();
				connection.commit();
				
				ps.close();
				return new QueryResult(true,"success");
			} catch (SQLException e) {
				rollbackConnection();
				return new QueryResult(false, (EXCEPTION_TAG + " " + e.getMessage()));
			}
		}

		@Override
		public QueryResult deletePass(int pid) {
			try {
				PreparedStatement ps = connection.prepareStatement("DELETE FROM Passenger WHERE pid = ?");
				ps.setInt(1, pid);
				
				int rowCount = ps.executeUpdate();
				
				connection.commit();
		
				ps.close();
				
				if (rowCount == 0) {
					return new QueryResult(false, (WARNING_TAG + " Passenger " + pid + " does not exist!"));
				}
				return new QueryResult(true,"success");
			} catch (SQLException e) {
				rollbackConnection();
				return new QueryResult(false, (EXCEPTION_TAG + " " + e.getMessage()));
			}
		}

		@Override
		public QueryResult deleteTicket(int ticket_no) {
			try {
				PreparedStatement ps = connection.prepareStatement("DELETE FROM Ticket WHERE ticket_no = ?");
				ps.setInt(1, ticket_no);
				
				int rowCount = ps.executeUpdate();
				
				connection.commit();
		
				ps.close();
				
				if (rowCount == 0) {
					return new QueryResult(false, (WARNING_TAG + " Ticket " + ticket_no + " does not exist!"));
				}
				return new QueryResult(true,"success");
			} catch (SQLException e) {
				rollbackConnection();
				return new QueryResult(false, (EXCEPTION_TAG + " " + e.getMessage()));
			}
		}

		@Override
		public QueryResult delete_all_tickets() {
			try {
				PreparedStatement ps = connection.prepareStatement("DELETE FROM Ticket");
				
				ps.executeUpdate();
				
				connection.commit();
		
				ps.close();
				
				return new QueryResult(true,"success");
			} catch (SQLException e) {
				rollbackConnection();
				return new QueryResult(false, (EXCEPTION_TAG + " " + e.getMessage()));
			}
		}
		
		@Override
		public JTable show_by_class(String class_) {
			String[][] result = null;
			JTable table = null;
			try {
				PreparedStatement ps = connection.prepareStatement("SELECT *"+
						"FROM Ticket WHERE class = ?", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ps.setString(1, class_);
				
				ResultSet rs = ps.executeQuery();
				
				
	    		ResultSetMetaData rsmd = rs.getMetaData();
	    		
	    		rs.last();
				int rows = rs.getRow();
				int columns = rsmd.getColumnCount();
	    		
	    		result = new String [rows][columns];
	    		String[] headers = new String[columns];
	    		System.out.println(" ");
	
	    		for (int i = 0; i < columns; i++) {
	    			// get column name 
	    			headers[i] = rsmd.getColumnName(i + 1);
	    		}
	    		
				rs.first();
				
				for (int i =0; i<rows && rs.next(); i++) {
					result[i][0] = String.valueOf(rs.getInt(1));
					result[i][1] = String.valueOf(rs.getInt(2));
					result[i][2] = rs.getString(3);
				}

				rs.close();
				ps.close();
				table = new JTable(result, headers);
			} catch (SQLException e) {
				System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			}	
			
			return table;
		}
		
		@Override
		public JTable proj_status(String [] cols){
			String[][] result = null;
			JTable table = null;
			try {
				
				StringBuffer statement = new StringBuffer("SELECT");
				for(int  i =0; i<cols.length;i++){
				if (i==0){statement.append(" ?"); continue;}
				statement.append(", ?");
				}
				
				PreparedStatement ps = connection.prepareStatement(statement.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
				for(int  i =0; i<cols.length;i++){
					ps.setString(i, cols[i]);
					}
				
				
				ResultSet rs = ps.executeQuery();
				
				
	    		ResultSetMetaData rsmd = rs.getMetaData();
	    		
	    		rs.last();
				int rows = rs.getRow();
				int columns = rsmd.getColumnCount();
	    		
	    		result = new String [rows][columns];
	    		String[] headers = new String[columns];
	    		System.out.println(" ");
	
	    		for (int i = 0; i < columns; i++) {
	    			// get column name 
	    			headers[i] = rsmd.getColumnName(i + 1);
	    		}
	    		
				rs.first();
				
				for (int i =0; i<rows && rs.next(); i++) {
					for(int j=0;j <columns; j++){
						result[i][j] = rs.getString(j);
					}
				}

				rs.close();
				ps.close();
				table = new JTable(result, headers);
			} catch (SQLException e) {
				System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			}	
			
			return table;
		}
		
		@Override
		public JTable join() {
			String[][] result = null;
			JTable table = null;
			try {
				String join = "SELECT p.pid, p.last_name, p.first_name "
						+ "FROM Passenger p, Ticket t, Ticket_Seat ts, Train_Operates_On_Route tr, Route_name rn, Route_Details rd"
						+ "Where p.pid = t.pid AND t.ticket_no = ts.ticket_no AND ts.train_id = tr.train_id AND"
						+ "tr.route_id = rn.route_id AND rn.route_name = rd.route_name AND rd.start_station_name = rd.start_station_name";
				PreparedStatement ps = connection.prepareStatement(join, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

				
				ResultSet rs = ps.executeQuery();
				
				
	    		ResultSetMetaData rsmd = rs.getMetaData();
	    		
	    		rs.last();
				int rows = rs.getRow();
				int columns = rsmd.getColumnCount();
	    		
	    		result = new String [rows][columns];
	    		String[] headers = new String[columns];
	    		System.out.println(" ");
	
	    		for (int i = 0; i < columns; i++) {
	    			// get column name 
	    			headers[i] = rsmd.getColumnName(i + 1);
	    		}
	    		
				rs.first();
				
				for (int i =0; i<rows && rs.next(); i++) {
					result[i][0] = String.valueOf(rs.getInt(1));
					result[i][1] = String.valueOf(rs.getInt(2));
					result[i][2] = rs.getString(3);
				}

				rs.close();
				ps.close();
				table = new JTable(result, headers);
			} catch (SQLException e) {
				System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			}	
			
			return table;
		}
	
	public BranchModel[] getBranchInfo() {
		ArrayList<BranchModel> result = new ArrayList<BranchModel>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM branch");
		
//    		// get info on ResultSet
//    		ResultSetMetaData rsmd = rs.getMetaData();
//
//    		System.out.println(" ");
//
//    		// display column names;
//    		for (int i = 0; i < rsmd.getColumnCount(); i++) {
//    			// get column name and print it
//    			System.out.printf("%-15s", rsmd.getColumnName(i + 1));
//    		}
			
			while(rs.next()) {
				BranchModel model = new BranchModel(rs.getString("branch_addr"),
													rs.getString("branch_city"),
													rs.getInt("branch_id"),
													rs.getString("branch_name"),
													rs.getInt("branch_phone"));
				result.add(model);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		
		return result.toArray(new BranchModel[result.size()]);
	}
	
	public void updateBranch(int id, String name) {
		try {
		  PreparedStatement ps = connection.prepareStatement("UPDATE branch SET branch_name = ? WHERE branch_id = ?");
		  ps.setString(1, name);
		  ps.setInt(2, id);
		
		  int rowCount = ps.executeUpdate();
		  if (rowCount == 0) {
		      System.out.println(WARNING_TAG + " Branch " + id + " does not exist!");
		  }
	
		  connection.commit();
		  
		  ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}	
	}
	
	public boolean login(String username, String password) {
		try {
			if (connection != null) {
				connection.close();
			}
	
			connection = DriverManager.getConnection(ORACLE_URL, username, password);
			connection.setAutoCommit(false);
	
			System.out.println("\nConnected to Oracle!");
			return true;
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			return false;
		}
	}

	private void rollbackConnection() {
		try  {
			connection.rollback();	
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	
	private void dropBranchTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");
			
			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("branch")) {
					stmt.execute("DROP TABLE branch");
					break;
				}
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	@Override
	public void setupDB() {
		dropBranchTableIfExists();
		
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE branch (branch_id integer PRIMARY KEY, branch_name varchar2(20) not null, branch_addr varchar2(50), branch_city varchar2(20) not null, branch_phone integer)");
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
		
		BranchModel branch1 = new BranchModel("123 Charming Ave", "Vancouver", 1, "First Branch", 1234567);
		insertBranch(branch1);
		
		BranchModel branch2 = new BranchModel("123 Coco Ave", "Vancouver", 2, "Second Branch", 1234568);
		insertBranch(branch2);
	}

	public JTable getTickets() {
		String[][] result = null;
		JTable table = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT *"+"FROM Ticket", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = ps.executeQuery();
			
			
    		ResultSetMetaData rsmd = rs.getMetaData();
    		
    		rs.last();
			int rows = rs.getRow();
			int columns = rsmd.getColumnCount();
    		
    		result = new String [rows][columns];
    		String[] headers = new String[columns];
    		System.out.println(" ");

    		for (int i = 0; i < columns; i++) {
    			// get column name 
    			headers[i] = rsmd.getColumnName(i + 1);
    		}
    		
			rs.first();
			
			for (int i =0; i<rows && rs.next(); i++) {
				result[i][0] = String.valueOf(rs.getInt(1));
				result[i][1] = String.valueOf(rs.getInt(2));
				result[i][2] = rs.getString(3);
			}

			rs.close();
			ps.close();
			table = new JTable(result, headers);
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		
		return table;
	}
	
	public JTable getTicket_book_status() {
		String[][] result = null;
		JTable table = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT *"+
					"FROM Ticket_book_status", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = ps.executeQuery();
			
			
    		ResultSetMetaData rsmd = rs.getMetaData();
    		
    		rs.last();
			int rows = rs.getRow();
			int columns = rsmd.getColumnCount();
    		
    		result = new String [rows][columns];
    		String[] headers = new String[columns];
    		System.out.println(" ");

    		for (int i = 0; i < columns; i++) {
    			// get column name 
    			headers[i] = rsmd.getColumnName(i + 1);
    		}
    		
			rs.first();
			
			for (int i =0; i<rows && rs.next(); i++) {
				result[i][0] = String.valueOf(rs.getInt(1));
				result[i][1] = String.valueOf(rs.getInt(2));
				result[i][2] = rs.getString(3);
			}

			rs.close();
			ps.close();
			table = new JTable(result, headers);
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		
		return table;
	}



}
