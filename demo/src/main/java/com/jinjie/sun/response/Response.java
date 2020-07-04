package com.jinjie.sun.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 定义一个统一的接口返回类
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Integer code;
    private String message;
    private Object result;
}
