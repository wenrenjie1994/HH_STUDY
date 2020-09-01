package com.cuit.project;

import com.cuit.iterator.IProjectIterator;
import com.cuit.iterator.ProjectIterator;

import java.util.ArrayList;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Project implements IProject {
    /**
     * 功能描述:
     * 定义一个项目列表，说有的项目都放在这里
     *
     * @author: liwenyi
     */
    private ArrayList<IProject> projectList = new ArrayList<IProject>();
    /**
     * 功能描述:
     * 项目名
     *
     * @author: liwenyi
     */
    private String name = "";
    /**
     * 功能描述:
     * 项目成员数量
     *
     * @author: liwenyi
     */
    private int num = 0;
    /**
     * 功能描述:
     * 项目费用
     *
     * @author: liwenyi
     */
    private int cost = 0;

    public Project() {
    }

    /**
     * 功能描述:
     * 定义一个构造函数，把所有老板需要看到的信息存储起来
     *
     * @param name 1
     * @param num  2
     * @param cost 3
     * @return:
     * @author: liwenyi
     */
    public Project(String name, int num, int cost) {
        //赋值到类的成员变量中
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    @Override
    public String getProjectInfo() {
        String info = "";
        //获得项目的名称
        info = info + "项目名称是：" + this.name;
        //获得项目人数
        info = info + "\t项目人数: " + this.num;
        //项目费用
        info = info + "\t 项目费用：" + this.cost;
        return info;
    }

    @Override
    public void add(String name, int num, int cost) {
        this.projectList.add(new Project(name, num, cost));
    }

    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator(this.projectList);
    }
}
