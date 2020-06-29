package com.spdb.study.design.pattern.template.course;

/**
 * 模拟疫情期间教师端备网课的标准化流程
 * 适用场景：
 * 1、一次性实现一个算法的不变部分，并将可变的行为留给子类来实现
 * 2、各子类中公共的行为被提取出来并集中到一个公共的父类中，从而避免代码的重复
 * 优点：
 * 1、提高代码的复用性
 * 2、提高代码的扩展性
 * 3、符合开闭原则
 * 缺点：
 * 1、类的数目增加
 * 2、间接地增加了系统实现的复杂度
 * 3、继承关系自身缺点，如果父类添加新的抽象方法，所有子类都需要修改
 * @author Mr.Longyx
 * @date 2020年06月29日 16:58
 */
public abstract class NetworkCourse {
    protected final void createCourse(){
        //1、发布预习资料
        this.postPreResource();

        //2、制作备课PPT
        this.createPPT();

        //3、在线上课直播
        this.Live();

        //4、提交课件、课堂笔记
        this.postNote();

        //5、布置作业
        if (needHomeWork()){
            checkHomeWork();
        }

    }

    protected abstract void checkHomeWork();

    /**
     * 该方法实现流程微调
     * @author Mr.Longyx
     * @date 2020/6/29 17:15
     * @return boolean
     */
    protected  boolean needHomeWork(){
        return false;
    }

    protected final void postNote(){
        System.out.println("提交课件和课堂笔记供学生下载");
    }

    protected final void Live(){
        System.out.println("在线直播授课");
    }

    protected final void createPPT(){
        System.out.println("制作上课PPT");
    }

    protected final void postPreResource(){
        System.out.println("分发预习资料");
    }
}
