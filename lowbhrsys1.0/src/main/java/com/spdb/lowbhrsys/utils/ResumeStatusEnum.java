package com.spdb.lowbhrsys.utils;

/**
 * @author: libobo
 * @create: 2020-07-03 13:47
 * @description: 简历状态枚举类
 **/
public enum ResumeStatusEnum {
    APPLIED(0,"已申请"),
    Resume_PASS(1,"简历通过"),
    WRITTEN_PASS(2,"笔试通过"),
    INTRVIEW_PASS(3,"面试通过"),
    HEALTH_EXAMINATION_PASS(4,"体检通过"),
    BACKGROUND_CHECK_PASS(5,"背景调查通过"),
    SIGN_PASS(6,"签约成功"),
    ENTRY_PASS(7,"已入职");

    private int status;
    private String msg;

    ResumeStatusEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
