package com.spdb.study.design.pattern.prototype.shallow;

import java.util.ArrayList;

/**
 * 此处为浅克隆(克隆的是原对象的地址，而不是原对象的值)
 * @author Mr.Longyx
 * @date 2020年06月25日 22:41
 */
public class ProtoTypeTest {
    public static void main(String[] args) {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();

        concretePrototype.setAge(18);
        concretePrototype.setName("Joe");
        concretePrototype.setHobbies(new ArrayList<>());

        Client client = new Client();
        ConcretePrototypeA copy = (ConcretePrototypeA)client.initClone(concretePrototype);
        System.out.println(copy);

        System.out.println("克隆对象中引用地址的值："+copy.getName());
        System.out.println("原对象中的引用地址的值："+concretePrototype.getName());
        System.out.println("对象地址比较："+(copy.getName() == concretePrototype.getName()));
    }
}
