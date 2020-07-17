package com.spdb.response;

/**
 * @author ：liwenyi
 * @version : 1.0
 * @description：返回前端
 * @date ：2019/10/28
 */


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spdb.emun.ResponseMessage;
import com.spdb.emun.ResponseState;
import com.spdb.util.ValidateUtils;
import org.springframework.validation.BindingResult;

import java.io.Serializable;

import static com.spdb.emun.ResponseMessage.PARAM_ERROR;

public class Response<T> implements Serializable {
    private Response.Meta meta;
    private T data;

    public Response() {
    }

    public Boolean checkState() {
        return this.meta.getCode() == ResponseState.SUCCESS.getCode();
    }

    public Response success() {
        this.meta = new Response.Meta(ResponseState.SUCCESS);
        return this;
    }

    public Response warning() {
        this.meta = new Response.Meta(ResponseState.WARNING);
        return this;
    }

    public Response success(T data) {
        this.success();
        this.data = data;
        return this;
    }

    public Response message(String message) {
        this.getMeta().setMessage(message);
        return this;
    }

    public Response data(T data) {
        this.data = data;
        return this;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.getMeta().getCode() == ResponseState.SUCCESS.getCode();
    }

    public Response failure() {
        this.meta = new Response.Meta(ResponseState.FAIL);
        return this;
    }

    public String getErrorMsg(BindingResult result) {
        return ValidateUtils.getValidateErrors(result.getAllErrors());
    }

    public Response failure(BindingResult result) {
        this.meta = new Response.Meta(PARAM_ERROR.getCode(), ValidateUtils.getValidateErrors(result.getAllErrors()));
        return this;
    }

    public Response failure(String message) {
        this.meta = new Response.Meta(ResponseState.FAIL, message);
        return this;
    }

    public Response failure(int code, String message) {
        this.meta = new Response.Meta(code, message);
        return this;
    }

    public Response failure(ResponseMessage responseMessage) {
        this.meta = new Response.Meta(responseMessage.getCode(), responseMessage.getMessage());
        return this;
    }

    public Response failure(String message, T data) {
        this.failure(message);
        this.data = data;
        return this;
    }

    public Response.Meta getMeta() {
        return this.meta;
    }

    public T getData() {
        return this.data;
    }

    public Response setData(T data) {
        this.data = data;
        return this;
    }

    public static class Meta implements Serializable {
        private int code;
        private String message;

        public Meta() {
        }

        public Meta(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public Meta(ResponseState responseState) {
            this.setCode(responseState.getCode());
            this.message = responseState.getCodeInfo();
        }

        public Meta(ResponseState responseState, String message) {
            if (message == null) {
                message = responseState.getCodeInfo();
            }

            this.message = message;
        }

        public int getCode() {
            return this.code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public void setCode(ResponseState state) {
            this.code = state.getCode();
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

