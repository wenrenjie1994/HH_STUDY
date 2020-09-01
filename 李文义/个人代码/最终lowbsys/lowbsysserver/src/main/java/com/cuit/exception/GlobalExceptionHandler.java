package com.cuit.exception;

import com.cuit.response.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liwenyi
 * @date 2020/7/24
 * desc 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleException(Exception exception) {
        return new Response().failure(exception.toString());
    }
}
