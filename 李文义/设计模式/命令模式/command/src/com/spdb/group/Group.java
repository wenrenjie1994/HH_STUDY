package com.spdb.group;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public abstract class Group {
    /**
     * 功能描述:
     * 甲乙双方分开办公，如果你要和某个组讨论，你首先要找到这个组
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void find();
    /**
     * 功能描述:
     * 被要求增加功能
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void add();
    /**
     * 功能描述:
     * 被要求删除功能
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void delete();
    /**
     * 功能描述:
     * 被要求修改功能
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void change();
    /**
     * 功能描述:
     * 被要求给出所有的变更计划
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void plan();
}
