package com.spdb.study.design.pattern.prototype.shallow;

import java.util.List;

/**
 * 原型模式简易版本
 * @author Mr.Longyx
 * @date 2020年06月25日 22:31
 */
public class ConcretePrototypeA implements Prototype{
    private Integer age;
    private String name;
    private List<String> hobbies;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public Prototype clone() {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(this.age);
        concretePrototype.setName(this.name);
        concretePrototype.setHobbies(this.hobbies);

        return concretePrototype;
    }
}
