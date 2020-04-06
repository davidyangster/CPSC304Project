package delegates;

import controller.QueryResult;

public interface TrainSystemDelegate {
    QueryResult handleCreateUser(String pid, String firstName, String lastName);

    /** handleBuyTicket is overloaded for buying economy or firstclass tickets */
    QueryResult handleBuyTicket(String pid, String seatClass, String trainId, String row_, String seat_no);

    QueryResult handleBuyTicket(String pid, String seatClass, String trainId,
                                String row_, String seat_no, String drink, String food, String entertainment);

    QueryResult deleteUser(String pid);

    QueryResult deleteTicket(String ticket_no);

    QueryResult updateStatus(String ticket_no, String pid, String status);

    QueryResult showAllUsers();

}
