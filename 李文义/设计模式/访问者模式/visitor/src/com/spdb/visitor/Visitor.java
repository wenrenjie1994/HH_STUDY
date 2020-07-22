package com.spdb.visitor;

import com.spdb.employee.CommonEmployee;
import com.spdb.employee.Employee;
import com.spdb.employee.Manager;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class Visitor implements IVisitor {
    @Override
    public void visit(CommonEmployee commonEmployee) {
        System.out.println(this.getCommonEmployee(commonEmployee));
    }

    @Override
    public void visit(Manager manager) {
        System.out.println(this.getManagerInfo(manager));
    }
    /**
     * 功能描述:
     * 组装出基本信息
     *
     * @param employee 1
     * @return: java.lang.String
     * @author: liwenyi
     */
    private String getBasicInfo(Employee employee){
        String info = "姓名：" + employee.getName() + "\t";
        info = info + "性别：" + (employee.getSex() == Employee.FEMALE?"女":"男") + "\t";
        info = info + "薪水：" + employee.getSalary() + "\t";
        return info;
    }
    /**
     * 功能描述:
     * 组装出部门经理的信息
     *
     * @param manager 1
     * @return: java.lang.String
     * @author: liwenyi
     */
    private String getManagerInfo(Manager manager){
        String basicInfo = this.getBasicInfo(manager);
        String otherInfo = "业绩："+manager.getPerformance() + "\t";
        return basicInfo + otherInfo;
    }
    /**
     * 功能描述:
     * 组装出普通员工信息
     *
     * @param commonEmployee 1
     * @return: java.lang.String
     * @author: liwenyi
     */
    private String getCommonEmployee(CommonEmployee commonEmployee){
        String basicInfo = this.getBasicInfo(commonEmployee);
        String otherInfo = "工作："+commonEmployee.getJob()+"\t";
        return basicInfo + otherInfo;
    }
}
