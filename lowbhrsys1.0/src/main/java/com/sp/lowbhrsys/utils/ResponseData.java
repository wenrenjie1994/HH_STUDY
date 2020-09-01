package com.sp.lowbhrsys.utils;

/**
 * @author: libobo
 * @create: 2020-07-03 14:25
 * @description: 响应类
 **/
public class ResponseData<T> {
    /**
     * 状态码
     */
    private int code;
    /**
     * 响应描述信息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;

    public ResponseData() {
    }

    public ResponseData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(int code,T data) {
        this.code = code;
        this.data=data;
    }
    public ResponseData(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseData<T> returnSuccess(){
        return new ResponseData<T>(200,"success");
    }

    public static <T> ResponseData<T> returnData(T data){
        return new ResponseData<>(200,"success",data);
    }

    public static <T> ResponseData<T> returnError(String msg){
        return new ResponseData<T>(400,msg);
    }

}
