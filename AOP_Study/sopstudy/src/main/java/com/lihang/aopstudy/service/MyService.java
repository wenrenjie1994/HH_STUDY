package com.lihang.aopstudy.service;

import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/23
 */
@Service
public class MyService {
    public void getById(String id){
        System.out.println("GetById:ArgType is String");
    }
    public void getById(Integer id){
        System.out.println("GetById:ArgType is Integer");
    }
}
