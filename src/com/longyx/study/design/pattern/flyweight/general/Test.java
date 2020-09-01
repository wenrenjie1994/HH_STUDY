package com.spdb.study.design.pattern.flyweight.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月05日 23:23
 */
public class Test {
    public static void main(String[] args) {
        TeacherFactory factory = new TeacherFactory();

        Teacher teacher = factory.getTeacher("0102054");
        Teacher teacher2 = factory.getTeacher("0102055");
        Teacher teacher3 = factory.getTeacher("0102054");

        System.out.println(teacher == teacher3);
    }
}
