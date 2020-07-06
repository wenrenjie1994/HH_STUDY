package com.spdb.study.design.pattern.composite.course.transparent;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 10:31
 */
public class Course extends CourseComponent {
    private String name;
    private String comment;

    public Course(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    @Override
    public String getName(CourseComponent component) {
        return this.name;
    }

    @Override
    public String getComment(CourseComponent component) {
        return this.comment;
    }

    @Override
    public void print() {
        System.out.println(name + "  课程导语： "+comment);
    }
}
