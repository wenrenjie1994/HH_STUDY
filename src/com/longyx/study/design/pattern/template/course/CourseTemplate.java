package com.spdb.study.design.pattern.template.course;

/**
 * 模板模式适用场景：
 * 1、一次性实现一个算法的不变的部分，并将可变的行为留给子类来实现
 * 2、各子类中公共的行为被提取出来并集中到一个公共的父类中，从而避免代码的重复
 * @author Mr.Longyx
 * @date 2020年07月01日 13:12
 */
public abstract class CourseTemplate {
    protected  final void createCourse(){
        //1、分发预习资料
        this.postPreResource();

        //2、制作上课PPT课件
        this.createPPT();

        //3、在线直播授课
        this.live();

        //4、提交课件、课堂笔记
        this.postNote();

        if (needHomework()){
            checkHomeWork();
        }
    }

    //该方法实现微调
    protected  boolean needHomework(){
        return false;
    }

    //该方法实现定制化实现
    protected abstract void checkHomeWork();

    protected final void postNote(){
        System.out.println("提交上课课件和笔记");
    }

    protected final void live(){
        System.out.println("疫情期间在线直播授课");
    }

    protected final void createPPT(){
        System.out.println("创建备课PPT");
    }

    protected final void postPreResource(){
        System.out.println("分发预习资料");
    }
}
