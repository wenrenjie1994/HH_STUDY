package bean;

public class Request {
    private String head;
    private Object data;

    public Request() {
    }

    public Request(String head, Object data) {
        this.head = head;
        this.data = data;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
