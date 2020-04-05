package delegates;
import model.TupleModel;
public interface TableDelegate {
    public void databaseSetup();

    public void deleteTuples(int branchId);
    public void insertTuple(TupleModel model);
    public void showTuples();
    public void updateTable(int branchId, String name);

    public void TransactionFinished();
}
