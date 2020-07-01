package com.spdb.study.design.pattern.factory.simplefactory.course;

/**
 * 简单工厂测试类
 * @author Mr.Longyx
 * @date 2020年06月21日 13:37
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        /**
         * 未引入工厂(每次都需要new它的实现类，繁琐)
         * @author Mr.Longyx
         * @date 2020/6/21 13:38
         */
//        ICourse course = new JavaCourse();
//        course.getCourse();

        /**
         * 引入简单工厂 v1.0(待优化)
         * @author Mr.Longyx
         * @date 2020/6/21 13:53
         */

//        CourseFactory factory = new CourseFactory();
//        ICourse course = factory.choice("java");
//        course.getCourse();


        /**
         * version:2.0
         * @author Mr.Longyx
         * @date 2020/6/21 14:10
         */

//        CourseFactory factory = new CourseFactory();
//        ICourse course = factory.choice("com.spdb.study.design.pattern.factory.simplefactory.JavaCourse");
//        course.getCourse();

        /**
         * version:3.0
         * Class的方式
         * @author Mr.Longyx
         * @date 2020/6/21 14:20
         */

        CourseFactory factory = new CourseFactory();
        ICourse course = factory.choice(PythonCourse.class);
        course.getCourse();
    }
}
