package com.spdb.iterator;

import com.spdb.project.IProject;

import java.util.ArrayList;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class ProjectIterator implements IProjectIterator {

    /**
     * 功能描述:
     * 所有的项目都放在ArrayList中
     *
     * @return:
     * @author: liwenyi
     */
    private ArrayList<IProject> projectList = new ArrayList<IProject>();
    private int currentItem = 0;

    /**
     * 功能描述:
     * 构造函数传入projectList
     *
     * @param projectList 1
     * @return:
     * @author: liwenyi
     */
    public ProjectIterator(ArrayList<IProject> projectList) {
        this.projectList = projectList;
    }

    /**
     * 功能描述:
     * 判断是否还有元素，必须实现
     *
     * @return: boolean
     * @author: liwenyi
     */
    @Override
    public boolean hasNext() {
        //定义一个返回值
        boolean b = true;
        if (this.currentItem >= projectList.size()) {
            b = false;
        }
        return b;
    }

    /**
     * 功能描述:
     * 取得下一个值
     *
     * @return: com.spdb.project.IProject
     * @author: liwenyi
     */
    @Override
    public IProject next() {
        return (IProject)this.projectList.get(this.currentItem++);
    }
}
