package com.cuit.visitor;

import com.cuit.employee.CommonEmployee;
import com.cuit.employee.Manager;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public interface IVisitor {
    /**
     * 功能描述:
     * 首先，定义我可以访问普通员工
     *
     * @param commonEmployee 1
     * @return: void
     * @author: liwenyi
     */
    public void visit(CommonEmployee commonEmployee);

    /**
     * 功能描述:
     * 其次，定义我还可以访问部门经理
     *
     * @param manager 1
     * @return: void
     * @author: liwenyi
     */
    public void visit(Manager manager);
}
