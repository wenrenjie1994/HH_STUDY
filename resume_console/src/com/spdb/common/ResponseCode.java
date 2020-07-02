package com.spdb.common;


/**
 * @Author: A wei
 * @Date: 2020/6/30 12:12
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */

public enum ResponseCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(-1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEAGE_ARGUMENT(100,"ILLEAGE_ARGUMENT");


    private int code;
    private String desc;

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return this.code;
    }

    public String getDesc() {
        return desc;
    }
}
