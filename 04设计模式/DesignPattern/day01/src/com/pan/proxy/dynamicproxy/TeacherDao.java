package com.pan.proxy.dynamicproxy;

public class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("老师正在授课...");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Hello" + name);
    }

}
