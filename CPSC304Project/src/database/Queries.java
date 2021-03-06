package database;

import javax.swing.JTable;

import controller.QueryResult;
import model.*;


public interface Queries {


	
	// Returns String with either success or error msg
	public QueryResult addPassenger(Passenger passenger); //insert passenger
	public QueryResult buyTicket(Ticket ticket); // insert ticket
	public QueryResult assignSeats(Ticket_Seat ts);
	public QueryResult update_book_status(Ticket_Book_Status tbs);
	public QueryResult deletePass (int Pid);
	public QueryResult deleteTicket(int ticket_no);
	public QueryResult delete_all_tickets();
	
	// Takes a string of either "economy" or "first class"
	public JTable show_by_class(String class_);
	public JTable proj_status(String [] cols);
	public JTable join();
	public JTable agg();
	public JTable nested_agg();
	public JTable div();
	public JTable getTickets();
	public JTable getTicket_book_status();
	public boolean login();

}
