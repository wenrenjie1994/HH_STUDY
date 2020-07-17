package com.jinjie.sun.controller;

import com.jinjie.sun.pojo.User;
import com.jinjie.sun.response.Response;
import com.jinjie.sun.response.ResponseBuilder;
import com.jinjie.sun.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/user")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Response login(@RequestBody Map<String, String> params) {
        try {
            String username = params.get("username").toString();
            String password = params.get("password").toString();
            System.out.println(1);
            System.out.println(username + ' ' + password);
            User user = userService.findByUsername(username);
            if (Objects.isNull(user))    return ResponseBuilder.buildFailResponse(null, "user not exists", 500);
            if (user.getPassword().equals(password)) return ResponseBuilder.buildSuccessResponse(user);
            return ResponseBuilder.buildFailResponse(null, "password error", 500);
        } catch (Exception e) {
            return ResponseBuilder.buildFailResponse(null, e.getMessage(), 500);
        }
    }

    @PostMapping("/add")
    @ApiOperation("添加User")
    public Response add(User user) {
        try {
            int result = this.userService.add(user);
            return ResponseBuilder.buildSuccessResponse(result);
        } catch (Exception e) {
            return ResponseBuilder.buildFailResponse(null, e.getMessage(), 500);
        }
    }

    @PostMapping("/update")
    @ApiOperation("修改User信息")
    public Response update(User user) {
        try {
            int result = this.userService.update(user);
            return ResponseBuilder.buildSuccessResponse(result);
        } catch (Exception e) {
            return ResponseBuilder.buildFailResponse(null, e.getMessage(), 500);
        }
    }

    @GetMapping("/delete")
    @ApiOperation("删除User")
    public Response delete(Long id) {
        try {
            int result = this.userService.delete(id);
            return ResponseBuilder.buildSuccessResponse(result);
        } catch (Exception e) {
            return ResponseBuilder.buildFailResponse(null, e.getMessage(), 500);
        }
    }

    @GetMapping("/get")
    @ApiOperation("获取某一个User")
    public Response findUser(Long id) {
        try {
            User result = this.userService.findUser(id);
            return ResponseBuilder.buildSuccessResponse(result);
        } catch (Exception e) {
            return ResponseBuilder.buildFailResponse(null, e.getMessage(), 500);
        }
    }

    /**
     * 获取User列表
     */
    @GetMapping("/list")
    @ApiOperation("获取User列表")
    public Response findUserList() {
        try {
            List<User> result = this.userService.findUserList();
            return ResponseBuilder.buildSuccessResponse(result);
        } catch (Exception e) {
            return ResponseBuilder.buildFailResponse(null, e.getMessage(), 500);
        }
    }
}
