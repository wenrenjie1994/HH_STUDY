package com.spdb.study.design.pattern.composite.course.safe;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 11:31
 */
public class File extends Directory {
    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
