package com.spdb.emun;


import static com.spdb.constant.ResponseMsgConstant.*;

/**
 * 返回状态
 */
public enum ResponseMessage {

    PARAM_ERROR(101,ERROR_PARAM),
    INSERT_ERROR(151, ERROR_INSERT),
    UPDATE_ERROR(152, ERROR_UPDATE),
    DELETE_ERROR(153,ERROR_DELETE);

    private int code;
    private String message;

    ResponseMessage(int code, String message) {
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