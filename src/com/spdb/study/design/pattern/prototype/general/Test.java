package com.spdb.study.design.pattern.prototype.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月13日 11:09
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 创建原型对象
         * @author Mr.Longyx
         * @date 2020/7/13 11:09
         */
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(18);
        prototype.setName("Komi");
        System.out.println(prototype);

        /**
         * 拷贝原型对象
         * @author Mr.Longyx
         * @date 2020/7/13 11:10
         */
        ConcretePrototype cloneType = prototype.clone();
        System.out.println(cloneType);
    }
}
