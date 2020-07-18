package bean;

import java.util.LinkedList;

public class Response {
    private boolean isSuccess;
    private String failReason;
    private Object data;

    public Response() {
    }

    public Response(boolean isSuccess, String failReason, Object data) {
        this.isSuccess = isSuccess;
        this.failReason = failReason;
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "isSuccess=" + isSuccess +
                ", failReason='" + failReason + '\'' +
                ", data=" + (LinkedList<Resume>)data +
                '}';
    }
}
