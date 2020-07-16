package bean;

import java.sql.ResultSet;

public class SQLResult {
    private int rows;
    private ResultSet resultSet;

    public SQLResult(int rows, ResultSet resultSet) {
        this.rows = rows;
        this.resultSet = resultSet;
    }

    public int getRows() {
        return rows;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
}
