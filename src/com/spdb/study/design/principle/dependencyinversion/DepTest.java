package com.spdb.study.design.principle.dependencyinversion;

/**
 * 面向抽象编程
 * @author Mr.Longyx
 * @date 2020年06月17日 12:42
 */
public class DepTest {
    public static void main(String[] args) {
        /**
         * version:1.0
         * @author Mr.Longyx
         * @date 2020/6/17 12:49
         *  Longyx longyx = new Longyx();
         *  longyx.studyJavaCourse();
         *  longyx.studyPythonCourse();
         *  longyx.studyAICourse();
         */

        /**
         * version:2.0
         * 注入的方式实现依赖倒置
         * @author Mr.Longyx
         * @date 2020/6/17 12:53
         *
         * Longyx list = new Longyx();
         * //        学Java
         * list.study(new JavaCourse());
         * //        学python
         * list.study(new PythonCourse());
         * //        学AI
         * list.study(new AICourse());
         */

        /**
         * version:3.0
         * 基于构造方法实现
         * @author Mr.Longyx
         * @date 2020/6/17 13:02
         *
         *  Longyx longyx = new Longyx(new JavaCourse());
         *  longyx.study();
         */

        /**
         * version:4.0
         * @author Mr.Longyx
         * @date 2020/6/17 13:05
         */
        Longyx longyx = new Longyx();
        longyx.setiCourse(new JavaCourse());
        longyx.study();

    }
}
