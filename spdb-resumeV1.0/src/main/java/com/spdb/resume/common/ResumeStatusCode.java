package com.spdb.resume.common;

/**
 * @Author: A wei
 * @Date: 2020/7/1 10:06
 * @Last Modified by:
 * @last Modified date:
 * @Description: 简历流程状态码
 */
public enum ResumeStatusCode {
    NOTAPPLY(-1,"NOT_APPLY"),
    APPLIED(0,"APPLIED"),
    PASSED(1,"PASSED"),
    WRITTEN(2,"PASS WRITTEN"),
    ITERVIEW(3,"PASS INTERVIEW"),
    BODY_CHECK(4,"PASS BODY CHECK"),
    BACKGROUND_CHECK(5,"PASS BACKGROUND CHECK"),
    SIGN(6,"SIGN UP"),
    INAUGURATION(7,"WELCOME TO SPDB");


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
