package com.spdb.resume.common;

/**
 * @Author: A wei
 * @Date: 2020/7/1 10:06
 * @Last Modified by:
 * @last Modified date:
 * @Description: 简历流程状态码
 */
public enum ResumeStatusCode {
    NOTAPPLY(0,"NOT_APPLY"),
    APPLIED(1,"APPLIED"),
    PASSED(2,"PASSED"),
    WRITTEN(3,"PASS WRITTEN"),
    ITERVIEW(4,"PASS INTERVIEW"),
    BODY_CHECK(5,"PASS BODY CHECK"),
    BACKGROUND_CHECK(6,"PASS BACKGROUND CHECK"),
    SIGN(7,"SIGN UP"),
    INAUGURATION(8,"WELCOME TO SPDB");


    private int code;
    private String message;

    ResumeStatusCode(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
