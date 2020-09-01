package com.spdb.study.hrs.hr3.manager;

import com.spdb.study.hrs.hr3.dataobject.Employee;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年07月23日 12:08
 */
public interface EmployeeManager {
    /**
     * 添加员工
     * @author Mr.Longyx
     * @date 2020/7/23 12:11
     * @param employee
     */
    void addEmployee(Employee employee);

    /**
     * 根据员工Id删除员工
     * @author Mr.Longyx
     * @date 2020/7/23 12:12
     * @param employeeId
     */
    void deleteEmployee(int employeeId);

    /**
     * 更新员工信息
     * @author Mr.Longyx
     * @date 2020/7/23 12:13
     * @param employee
     */
    void updateEmployee(Employee employee);

    /**
     * 分页查询
     * @author Mr.Longyx
     * @date 2020/7/23 12:14
     * @param pageNum 第几页(当前页码)
     * @param pageSize 每页显示条数
     * @return java.util.List<com.spdb.study.hrs.hr3.dataobject.Employee>
     */
    List<Employee> findEmployeeList(int pageNum, int pageSize);

    /**
     * 查询所有的员工信息
     * @author Mr.Longyx
     * @date 2020/7/24 20:14
     */
    List<Employee> findEmployeeList();
}
