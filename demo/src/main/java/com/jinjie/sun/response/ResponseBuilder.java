package com.jinjie.sun.response;

/**
 * 定义接口返回码
 */
public class ResponseBuilder {

    public static Response buildSuccessResponse(Object result) {
        Response response = new Response();
        response.setCode(200);
        response.setMessage("success");
        response.setResult(result);
        return response;
    }

    public static Response buildFailResponse(Object result, String msg) {
        Response response = new Response();
        response.setCode(500);
        response.setMessage(msg);
        response.setResult(result);
        return response;
    }
}
