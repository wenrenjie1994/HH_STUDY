package bean;

import java.util.List;

public class ResponseTemplate<T> {
    int rows;
    List<T> list;

    public ResponseTemplate(int rows, List<T> list) {
        this.rows = rows;
        this.list = list;
    }

    public ResponseTemplate() {
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
