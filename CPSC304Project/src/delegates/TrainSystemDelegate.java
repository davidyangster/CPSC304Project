package delegates;

import controller.QueryResult;

import javax.swing.*;

public interface TrainSystemDelegate {
    QueryResult createPassenger(String pid, String firstName, String lastName);

    /** handleBuyTicket is overloaded for buying economy or firstclass tickets */
    QueryResult buyTickets(String pid, String seatClass, String trainId, String row_, String seat_no);


    QueryResult deletePassenger(String pid);

    QueryResult deleteTicket(String ticket_no);

    QueryResult deleteAllTickets();

    QueryResult updateBookStatus(String ticket_no, String pid, String status);

    QueryResult showAllPassengers();

    JTable showPassengersByClass(String class_);

    JTable projectStatus(String[] columns);

    JTable getPassengerInfo();

    JTable getTicketTable();

    JTable getTickBookStatusTable();
}
