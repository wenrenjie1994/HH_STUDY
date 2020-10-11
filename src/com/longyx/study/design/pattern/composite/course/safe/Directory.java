package com.longyx.study.design.pattern.composite.course.safe;

/**
 * 顶层设计 抽象类 组合模式强调的是整体-部分的关系
 * 组合模式
 * 优点：
 * 1、清楚地定义分层次的复杂对象，表示对象的全部或部分层次
 * 2、让客户端忽略层次的差异，方便对整个层次结构进行控制
 * 3、简化客户端段代码
 * 4、符合开闭原则
 * 缺点：
 * 1、限制类型时会较为复杂
 * 2、使设计变得更加抽象
 * @author Mr.Longyx
 * @date 2020年07月06日 11:14
 */
public abstract class Directory {
    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    public abstract void show();
}
