package com.longyx.study.design.pattern.template.course;

/**
 * @author Mr.Longyx
 * @date 2020年07月01日 13:45
 */
public class CourseTest {
    public static void main(String[] args) {
        System.out.println("----Python在线教学课程----");
        CourseTemplate course = new PythonCourse();
        course.createCourse();

        System.out.println("---Java在线教学课程----");
        CourseTemplate courseTemplate = new JavaCourse(true);
        courseTemplate.createCourse();
    }
}
