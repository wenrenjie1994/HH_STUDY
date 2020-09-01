package com.spdb.study.design.pattern.composite.course.transparent;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 10:46
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("======透明的组合模式======");

        CourseComponent java = new Course("Java入门课程","适合小白同学学习");
        CourseComponent python = new Course("python", "人生苦短，我用python");

        CourseComponent coursePackage = new CoursePackage("慕课Java高级开发课程",2);

        CourseComponent design = new Course("Java设计模式","适合需要进一步提升的同学");
        CourseComponent softSkill = new Course("软技能","适合有提升软实力需求的同学");

        coursePackage.addChild(design);
        coursePackage.addChild(softSkill);

        CourseComponent catalog = new CoursePackage("在校提高应用开发技能课程目录",1);
        catalog.addChild(coursePackage);
        catalog.addChild(java);
        catalog.addChild(python);

        catalog.print();
    }
}
