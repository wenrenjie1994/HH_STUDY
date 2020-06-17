package com.spdb.study.design.principle.liskosubstitution.methodreturn;

import java.util.HashMap;

/**
 * 子类的参数返回值范围必须小于父类参数返回值范围
 * @author Mr.Longyx
 * @date 2020年06月17日 22:05
 */
public class Child extends Base {

    @Override
    public HashMap method() {
        HashMap map = new HashMap();
        System.out.println("执行子类method方法");
        map.put("msg","子类method");
        return map;
    }
}
