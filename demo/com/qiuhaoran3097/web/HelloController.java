package com.qiuhaoran3097.web;

/**
 * @Author: QiuhaoRan
 * @Description:
 * @Date: Created in 10:19 2020/5/23
 * @Modified By:
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

}