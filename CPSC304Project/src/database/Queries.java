package database;

import model.*;

public interface Queries {

	
	public void setupDB();
	
	// Returns String with either success or error msg
	public String addPassenger(Passenger passenger); //insert passenger
	public String buyTicket(Ticket ticket); // insert ticket
	public String assignSeats(Ticket_Seat ts);
	public String update_book_status(Ticket_Book_Status tbs);
	public String deletePass (int Pid);
	public String deleteTicket(int ticket_no);
	public String delete_all_tickets();
	
	
}
