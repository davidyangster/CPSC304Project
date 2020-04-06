package delegates;
import model.TupleModel;
public interface TableDelegate {
    public void databaseSetup();
    public void insertTuple(TupleModel model);
    public void deleteTuples(int tableId);
    public void showTuples(int tableId);
    public void updateTable(int tableId, String name);
    public void selectTuples(int tableId, String name);
    public void projectAttributes(int tableId);
    public void joinTable(TupleModel model);
    public void count(int tableId);
    public void groupBy();
    public void divideBy();

    public void TransactionFinished();
}
