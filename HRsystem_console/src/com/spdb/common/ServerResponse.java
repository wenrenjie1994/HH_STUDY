package com.spdb.common;


import com.sun.istack.internal.NotNull;

import java.io.Serializable;

/**
 * @Author: A wei
 * @Date: 2020/6/30 11:45
 * @Last Modified by:
 * @last Modified date:
 * @Description: 服务器响应类，负责返回响应结果
 */
public class ServerResponse<T> implements Serializable {

    @NotNull
    private int status;

    private String message;

    private T data;

    private ServerResponse(int status){
        this.status = status;
    }

    private ServerResponse(int status,String message){
        this.status = status;
        this.message = message;
    }

    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String message,T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> ServerResponse<T> createByError(){

        return new ServerResponse<T>(ResponseCode.ERROR.getCode());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String msg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),msg);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String msg){
        return new ServerResponse<T>(errorCode,msg);
    }
}
