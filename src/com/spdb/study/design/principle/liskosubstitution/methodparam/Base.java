package com.spdb.study.design.principle.liskosubstitution.methodparam;

import java.util.HashMap;

/**
 * 方法的输入和输出
 * @author Mr.Longyx
 * @date 2020年06月17日 21:44
 */
public class Base {
    public void method(HashMap map){
        System.out.println("执行父类方法");
    }
}
