package com.jinjie.sun.controller;

import com.jinjie.sun.pojo.HR;
import com.jinjie.sun.response.Response;
import com.jinjie.sun.response.ResponseBuilder;
import com.jinjie.sun.service.HRService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hr")
@Api(tags = "HR")
public class HRController {
    @Autowired
    private HRService hrService;


    @PostMapping("/add")
    @ApiOperation("添加HR")
    public Response add(HR hr) {
        try {
            int result = this.hrService.add(hr);
            return ResponseBuilder.buildSuccessResponse(result);
        } catch (Exception e) {
            return ResponseBuilder.buildFailResponse(null, e.getMessage());
        }
    }

    @PostMapping("/update")
    @ApiOperation("修改HR信息")
    public Response update(HR hr) {
        try {
            int result = this.hrService.update(hr);
            return ResponseBuilder.buildSuccessResponse(result);
        } catch (Exception e) {
            return ResponseBuilder.buildFailResponse(null, e.getMessage());
        }
    }

    @GetMapping("/delete")
    @ApiOperation("删除HR")
    public Response delete(Long id) {
        try {
            int result = this.hrService.delete(id);
            return ResponseBuilder.buildSuccessResponse(result);
        } catch (Exception e) {
            return ResponseBuilder.buildFailResponse(null, e.getMessage());
        }
    }

    @GetMapping("/get")
    @ApiOperation("获取某一个HR")
    public Response findHR(Long id) {
        try {
            HR result = this.hrService.findHR(id);
            return ResponseBuilder.buildSuccessResponse(result);
        } catch (Exception e) {
            return ResponseBuilder.buildFailResponse(null, e.getMessage());
        }
    }

    /**
     * 获取HR列表
     */
    @GetMapping("/list")
    @ApiOperation("获取HR列表")
    public Response findHRList() {
        try {
            List<HR> result = this.hrService.findHRList();
            return ResponseBuilder.buildSuccessResponse(result);
        } catch (Exception e) {
            return ResponseBuilder.buildFailResponse(null, e.getMessage());
        }
    }
}
