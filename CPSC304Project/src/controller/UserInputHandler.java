package controller;

import delegates.TrainSystemDelegate;

import javax.swing.*;
import model.*;
import database.*;

public class UserInputHandler implements TrainSystemDelegate {
    public static UserInputHandler instance = null;
    private static int ticketNumber = 0;
    private Queries databaseDelegate;

    private UserInputHandler() {
        databaseDelegate = new DatabaseConnectionHandler();
    }

    public static UserInputHandler getInstance() {
        if (instance == null) {
            instance = new UserInputHandler();
        }
        return instance;
    }
    @Override
    public QueryResult createPassenger(String pid, String firstName, String lastName) {
        if (!checkIsValidInt(pid) || !checkIsValidString(firstName) || !checkIsValidString(lastName)) {
            return new QueryResult(false, "Please enter a valid first and last name");
        }
        if (!checkIsValidInt(pid)) {
            return new QueryResult(false, "Please enter a valid passenger id (positive integer)");
        }

        int pidInt = Integer.parseInt(pid);
        Passenger passenger = new Passenger(pidInt, lastName, firstName);
        return databaseDelegate.addPassenger(passenger);
    }

    //handleBuyTicket is overloaded for buying economy or firstclass tickets
    @Override
    public QueryResult buyTickets(String pid, String seatClass, String trainId, String row_, String seat_no) {
        if (!checkIsValidInt(pid) || !checkIsValidString(seatClass) || !checkIsValidInt(trainId)
                || !checkIsValidInt(row_) || !checkIsValidInt(seat_no)) {
            return new QueryResult(false, "Please make sure all inputs are in correct format");
        }

        int pidInt = Integer.parseInt(pid);
        int trainIdInt = Integer.parseInt(trainId);
        int rowInt = Integer.parseInt(row_);
        int seatInt = Integer.parseInt(seat_no);
        //put parameters into database connection

        Ticket tic = new Ticket(ticketNumber, seatClass, pidInt);
        ticketNumber++;
        QueryResult addTicketResult = databaseDelegate.buyTicket(tic);
        if (!addTicketResult.success) {
            return addTicketResult;
        }
        Ticket_Seat ticketSeat = new Ticket_Seat(ticketNumber, rowInt, seatInt, trainIdInt);
        return databaseDelegate.assignSeats(ticketSeat);
    }

//    @Override
//    public QueryResult buyTickets(String pid, String seatClass, String trainId,
//                                  String row_, String seat_no, String drink, String food, String entertainment) {
//
//        if (!checkIsValidInt(pid) || !checkIsValidString(seatClass) || !checkIsValidInt(trainId)
//                || !checkIsValidString(drink) || !checkIsValidString(food) || !checkIsValidString(entertainment)
//                || !checkIsValidInt(row_) || !checkIsValidInt(seat_no)) {
//            return new QueryResult(false, "Please make sure all inputs are in correct format");
//        }
//
//        int pidInt = Integer.parseInt(pid);
//        int trainIdInt = Integer.parseInt(trainId);
//        int rowInt = Integer.parseInt(row_);
//        int seatInt = Integer.parseInt(seat_no);
//        //put parameters into database connection
//        return new QueryResult(true,"");
//    }

    @Override
    public QueryResult deletePassenger(String pid) {
        if (!checkIsValidInt(pid)) {
            return new QueryResult(false, "Please input valid passenger id");
        }
        int pidInt = Integer.parseInt(pid);
        return databaseDelegate.deletePass(pidInt);
    }

    @Override
    public QueryResult deleteTicket(String ticketNumber) {
        if (!checkIsValidInt(ticketNumber)) {
            return new QueryResult(false, "Please input valid ticket number");
        }
        int ticketNumInt = Integer.parseInt(ticketNumber);
        return databaseDelegate.deleteTicket(ticketNumInt);
    }

    @Override
    public QueryResult deleteAllTickets() {
        return databaseDelegate.delete_all_tickets();
    }

    @Override
    public QueryResult updateBookStatus(String ticket_no, String pid, String status) {
        if (!checkIsValidInt(ticket_no) || !checkIsValidInt(pid) || !checkIsValidString(status)) {
            return new QueryResult(false, "Please input valid ticket booking status info");
        }
        int ticketNumInt = Integer.parseInt(ticket_no);
        int pidInt = Integer.parseInt(pid);
        Ticket_Book_Status tbs = new Ticket_Book_Status(ticketNumInt, pidInt, status);
        return databaseDelegate.update_book_status(tbs);
    }

    @Override
    public JTable showPassengersByClass(String class_) {
        return databaseDelegate.show_by_class(class_);
    }

    @Override
    public JTable projectStatus(String[] columns) {
        return databaseDelegate.proj_status(columns);
    }

    @Override
    public JTable getPassengerInfo() {
        return null;
    }

    @Override
    public JTable getTicketTable() {
        return databaseDelegate.getTickets();
    }

    @Override
    public JTable getTickBookStatusTable() {
        return databaseDelegate.getTicket_book_status();
    }

    @Override
    public JTable join() {
        return databaseDelegate.join();
    }

    @Override
    public JTable aggregate() {
        return databaseDelegate.agg();
    }

    private boolean checkIsValidInt(String toCheck) {
        return toCheck != null && toCheck.length() != 0 && toCheck.matches("(0|[1-9]\\d*)");
    }

    private boolean checkIsValidString(String toCheck) {
        return toCheck != null && toCheck.length() != 0;
    }



}
