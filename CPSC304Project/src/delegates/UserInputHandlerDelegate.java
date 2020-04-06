package delegates;
import controller.QueryResult;
import model.*;

public interface UserInputHandlerDelegate {
    public QueryResult createUser(Passenger passenger);
}
