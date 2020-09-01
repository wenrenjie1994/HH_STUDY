package com.cuit.project;

import com.cuit.iterator.IProjectIterator;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public interface IProject {
    /**
     * 功能描述:
     * 从老板这里看到的就是项目信息
     *
     * @return: java.lang.String
     * @author: liwenyi
     */
    public String getProjectInfo();

    /**
     * 功能描述:
     * 增加项目
     *
     * @param name 1
     * @param num 2
     * @param cost 3
     * @return: void
     * @author: liwenyi
     */
    public void add(String name,int num,int cost);
    /**
     * 功能描述:
     * 获得一个可以被遍历的对象
     *
     * @return: IProjectIterator
     * @author: liwenyi
     */
    public IProjectIterator iterator();
}
