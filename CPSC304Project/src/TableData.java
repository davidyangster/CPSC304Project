import javax.swing.*;
public class TableData {
    protected JTable table;
    public String tableName;
    public String[] columns;

    public TableData(String id) {
        tableName = id;
        table = new JTable();
        //TODO: implement a way to set table = our table, and columnCount instantiated
    }

    public void groupBy (String[] groups) {

    }


}
