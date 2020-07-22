package com.spdb.model;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public abstract class SchoolReport {
    /**
     * 功能描述:
     * 成绩单主要展示的就是你的成绩情况
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void report();

    /**
     * 功能描述:
     * 成绩单要家长签字，这个是最要命的
     *
     * @param name 1
     * @return: void
     * @author: liwenyi
     */
    public abstract void sign(String name);
}
