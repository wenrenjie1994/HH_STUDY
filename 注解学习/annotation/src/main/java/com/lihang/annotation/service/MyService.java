package com.lihang.annotation.service;

import com.lihang.annotation.myannotation.MyAnnotation;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/23
 */
@Service
public class MyService {
    @MyAnnotation(name = "lihang",array = {1,2,3})
    public void getAll(Integer id){
        System.out.println("getALl");
    }
    @MyAnnotation(name = "lihang",array = {1,2,3})
    public void getAll(String id){
        System.out.println("getALl");
    }
}
