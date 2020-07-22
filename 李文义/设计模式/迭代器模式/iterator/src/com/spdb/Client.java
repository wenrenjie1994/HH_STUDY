package com.spdb;

import com.spdb.iterator.IProjectIterator;
import com.spdb.project.IProject;
import com.spdb.project.Project;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Client {
    public static void main(String[] args) {
        //定义一个List，存放所有的项目对象
        IProject project = new Project();
        //增加星球大战项目
        project.add("星球大战项目", 10, 100000);
        //增加扭转时空项目
        project.add("扭转时空项目", 100, 10000000);
        //增加超人改造项目
        project.add("超人改造项目", 10000, 1000000000);
        //遍历一下ArrayList，把所有的数据都取出
        //遍历一下ArrayList，把所有的数据都取出
        IProjectIterator projectIterator = project.iterator();
        while(projectIterator.hasNext()){
            IProject p = (IProject)projectIterator.next();
            System.out.println(p.getProjectInfo());
        }
    }
}
