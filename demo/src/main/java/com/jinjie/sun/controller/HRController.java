package com.jinjie.sun.controller;

import com.jinjie.sun.pojo.HR;
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
    public int add(HR hr) {
        return this.hrService.add(hr);
    }

    @PostMapping("/update")
    @ApiOperation("修改HR信息")
    public int update(HR hr) {
        return this.hrService.update(hr);
    }

    @GetMapping("/delete")
    @ApiOperation("删除HR")
    public int delete(Long id) {
        return this.hrService.delete(id);
    }

    @GetMapping("/get")
    @ApiOperation("获取某一个HR")
    public HR findHR(Long id) {
        return this.hrService.findHR(id);
    }

    /**
     * 获取HR列表
     */
    @GetMapping("/list")
    @ApiOperation("获取HR列表")
    public List<HR> findHRList() {
        return this.hrService.findHRList();
    }
}
