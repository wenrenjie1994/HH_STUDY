package com.longyx.study.design.pattern.composite.course.transparent;

/**
 * 所有方法都是空实现
 * 该种方式子类继承抽象方法后，会强制施加一些无关的方法给子类，违背了软件设计中迪米特法则(最少知道原则)
 * @author Mr.Longyx
 * @date 2020年07月06日 9:41
 */
public abstract class CourseComponent {
    public void addChild(CourseComponent component){
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void removeChild(CourseComponent component){
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public String getName(CourseComponent component){
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    public String getComment(CourseComponent component){
        throw new UnsupportedOperationException("不支持获取课程导语操作");
    }

    public void print(){
        throw new UnsupportedOperationException("不支持打印操作");
    }
}
