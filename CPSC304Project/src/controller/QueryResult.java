package controller;

public class QueryResult {
    public boolean success;
    public String sqlResult;

    public QueryResult(boolean success, String sqlResult) {
        this.success = success;
        this.sqlResult = sqlResult;
    }

}
