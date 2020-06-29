package com.spdb.study.design.pattern.template.course;

/**
 * 模版方法模式：适用于有标准化的流程
 * @author Mr.Longyx
 * @date 2020年06月29日 17:22
 */
public class NetWorkCourseTest {
    public static void main(String[] args) {
        System.out.println("---Java课程----");
        NetworkCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();

        System.out.println("---大数据课程----");
        NetworkCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();

        System.out.println("----Python课程----");
        NetworkCourse pythonCourse = new PythonCourse(false);
        pythonCourse.createCourse();
    }
}
