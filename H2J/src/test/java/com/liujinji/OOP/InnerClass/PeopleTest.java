package com.liujinji.OOP.InnerClass;

import org.junit.Test;

public class PeopleTest {
    @Test
    public void InnerClassTest(){
        People a = new People();
        People.Student b =a.new Student();
        System.out.println(b.getStudentInfo());
    }
}