package model;

import en.OperationEnum;
import en.StatusEnum;

import java.io.Serializable;

/**
 * @Author: chenlei
 * @Date: 2020/7/16 17:06
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = -6102317477228554190L;
    private StatusEnum status;
    private OperationEnum operation;
    private T data;

    public Response(){}
    public static <T> Response<T> success(T data,OperationEnum operation) {
        Response<T> response = new Response<T>();
        response.status = StatusEnum.SUCCESS;
        response.data = data;
        response.operation = operation;
        return response;
    }
    public static <T> Response<T> success(OperationEnum operation) {
        Response<T> response = new Response<T>();
        response.status = StatusEnum.SUCCESS;
        response.data = null;
        response.operation = operation;
        return response;
    }
    public static <T> Response<T> error(StatusEnum status,OperationEnum operation){
        Response<T> response = new Response<T>();
        response.status = status;
        response.operation = operation;
        return response;
    }

    public OperationEnum getOperation() {
        return operation;
    }

    public void setOperation(OperationEnum operation) {
        this.operation = operation;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
