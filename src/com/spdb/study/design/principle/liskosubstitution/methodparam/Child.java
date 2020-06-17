package com.spdb.study.design.principle.liskosubstitution.methodparam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 21:51
 */
public class Child extends Base {
//    @Override
//    public void method(HashMap map) {
//        System.out.println("子类HashMap入参方法执行");
//    }

    public void method(Map map) {
        System.out.println("子类Map入参方法的执行");
    }

}
