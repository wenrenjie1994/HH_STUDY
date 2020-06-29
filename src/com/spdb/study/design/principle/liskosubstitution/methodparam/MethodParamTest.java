package com.spdb.study.design.principle.liskosubstitution.methodparam;
import	java.util.HashMap;

/**
 * 子类的方法重载父类的方法时，方法的前置条件要比父类方法的输入参数更宽松
 * 满足父子关系的时候，替换类型不影响最终的执行结果
 * @author Mr.Longyx
 * @date 2020年06月17日 21:56
 */
public class MethodParamTest {
    public static void main(String[] args){
        Child child = new Child();
        HashMap map = new HashMap();
        child.method(map);
    }
}
