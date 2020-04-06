package controller;

import delegates.TrainSystemDelegate;

public class UserInputHandler implements TrainSystemDelegate {
    public static UserInputHandler instance = null;

    private UserInputHandler() {

    }

    public UserInputHandler getInstance() {
        if (instance == null) {
            instance = new UserInputHandler();
        }
        return instance;
    }
    @Override
    public QueryResult handleCreateUser(String pid, String firstName, String lastName) {
        if (!checkIsValidInt(pid) || !checkIsValidString(firstName) || !checkIsValidString(lastName)) {
            return new QueryResult(false, "Please enter a valid first and last name");
        }
        if (!checkIsValidInt(pid)) {
            return new QueryResult(false, "Please enter a valid passenger id (positive integer)");
        }

        int pidInt = Integer.parseInt(pid);
        //put parameters into database connection
        return new QueryResult(true,"");
    }

    //handleBuyTicket is overloaded for buying economy or firstclass tickets
    @Override
    public QueryResult handleBuyTicket(String pid, String seatClass, String trainId, String row_, String seat_no) {
        if (!checkIsValidInt(pid) || !checkIsValidString(seatClass) || !checkIsValidInt(trainId)
                || !checkIsValidInt(row_) || !checkIsValidInt(seat_no)) {
            return new QueryResult(false, "Please make sure all inputs are in correct format");
        }

        int pidInt = Integer.parseInt(pid);
        int trainIdInt = Integer.parseInt(trainId);
        int rowInt = Integer.parseInt(row_);
        int seatInt = Integer.parseInt(seat_no);
        //put parameters into database connection
        return new QueryResult(true,"");
    }

    @Override
    public QueryResult handleBuyTicket(String pid, String seatClass, String trainId,
                                       String row_, String seat_no, String drink, String food, String entertainment) {

        if (!checkIsValidInt(pid) || !checkIsValidString(seatClass) || !checkIsValidInt(trainId)
                || !checkIsValidString(drink) || !checkIsValidString(food) || !checkIsValidString(entertainment)
                || !checkIsValidInt(row_) || !checkIsValidInt(seat_no)) {
            return new QueryResult(false, "Please make sure all inputs are in correct format");
        }

        int pidInt = Integer.parseInt(pid);
        int trainIdInt = Integer.parseInt(trainId);
        int rowInt = Integer.parseInt(row_);
        int seatInt = Integer.parseInt(seat_no);
        //put parameters into database connection
        return new QueryResult(true,"");
    }

    @Override
    public QueryResult deleteUser(String pid) {
        return null;
    }

    @Override
    public QueryResult deleteTicket(String ticket_no) {
        return null;
    }

    @Override
    public QueryResult updateStatus(String ticket_no, String pid, String status) {
        return null;
    }

    @Override
    public QueryResult showAllUsers() {
        return null;
    }

    private boolean checkIsValidInt(String toCheck) {
        return toCheck != null && toCheck.length() != 0 && toCheck.matches("(0|[1-9]\\d*)");
    }

    private boolean checkIsValidString(String toCheck) {
        return toCheck != null && toCheck.length() != 0;
    }



}
