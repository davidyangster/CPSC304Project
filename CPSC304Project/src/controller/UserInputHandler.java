package controller;

public class UserInputHandler {
    public static QueryResult handleCreateUser(String pid, String firstName, String lastName ) {
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
    public static QueryResult handleBuyTicket(String pid, String seatClass, String trainId) {
        if (!checkIsValidInt(pid) || !checkIsValidString(seatClass) || !checkIsValidInt(trainId)) {
            return new QueryResult(false, "Please make sure all inputs are in correct format");
        }

        int pidInt = Integer.parseInt(pid);
        int trainIdInt = Integer.parseInt(trainId);

        return new QueryResult(true,"");
    }

    public static QueryResult handleBuyTicket(String pid, String seatClass, String trainId,
                                              String drink, String food, String entertainment) {
        if (!checkIsValidInt(pid) || !checkIsValidString(seatClass) || !checkIsValidInt(trainId)
                || !checkIsValidString(drink) || !checkIsValidString(food) || !checkIsValidString(entertainment)) {
            return new QueryResult(false, "Please make sure all inputs are in correct format");
        }

        int pidInt = Integer.parseInt(pid);
        int trainIdInt = Integer.parseInt(trainId);

        return new QueryResult(true,"");
    }

    private static boolean checkIsValidInt(String toCheck) {
        return toCheck != null && toCheck.length() != 0 && toCheck.matches("(0|[1-9]\\d*)");
    }

    private static  boolean checkIsValidString(String toCheck) {
        return toCheck != null && toCheck.length() != 0;
    }



}
