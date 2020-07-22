package com.spdb.command;

import com.spdb.group.CodeGroup;
import com.spdb.group.PageGroup;
import com.spdb.group.RequirementGroup;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public abstract class Command {
    /**
     * 功能描述:
     * 需求组
     *
     * @author: liwenyi
     */
    protected RequirementGroup rg = new RequirementGroup();
    /**
     * 功能描述:
     * 美工组
     *
     * @author: liwenyi
     */
    protected PageGroup pg = new PageGroup();
    /**
     * 功能描述:
     * 代码组
     *
     * @author: liwenyi
     */
    protected CodeGroup cg = new CodeGroup();
    /**
     * 功能描述:
     * 只有一个方法，你要我做什么事情
     *
     * @return: void
     * @author: liwenyi
     */
    public abstract void execute();
}
