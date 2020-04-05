import java.util.ArrayList;

public class StoreTable {
    private static ArrayList<TableData> allTables;
    public StoreTable(ArrayList<TableData> Tables) {
        allTables = new ArrayList<>();
        TableData tabs = new TableData("lol");
        allTables.add(tabs);
    }

    public TableData getTable(String tableName) {
        for (int i = 0; i< allTables.size(); i ++) {
            if (allTables.get(i).tableName == tableName) {
                return allTables.get(i);
            }
        }
        return null;
    }

    public ArrayList<TableData> getAllTables() {
        return allTables;
    }
}
