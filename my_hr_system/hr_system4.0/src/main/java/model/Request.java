package model;

import java.io.Serializable;

/**
 * 请求类
 * @Author: chenlei
 * @Date: 2020/7/16 17:06
 */
public class Request<T> implements Serializable {
    private static final long serialVersionUID = 3398662744507468777L;
    private int operationCode;
    private T data;

    @Override
    public String toString() {
        return "Request{" +
                "operationCode=" + operationCode +
                ", data=" + data +
                '}';
    }

    public Request(int operationCode, T data) {
        this.operationCode = operationCode;
        this.data = data;
    }

    public int getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(int operationCode) {
        this.operationCode = operationCode;
    }

    public T getInfo() {
        return data;
    }

    public void setInfo(T data) {
        this.data = data;
    }
}
