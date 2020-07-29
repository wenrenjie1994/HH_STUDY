package com.spdb.study.hrs.hr4.manager.impl;

import com.spdb.study.hrs.hr4.dataobject.Department;
import com.spdb.study.hrs.hr4.dataobject.Employee;
import com.spdb.study.hrs.hr4.manager.EmployeeManager;
import com.spdb.study.hrs.hr4.util.DbUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年07月23日 12:16
 */
public class EmployeeManagerImpl implements EmployeeManager {

    @Override
    public void addEmployee(Employee employee) {
        String sql = "insert into employee(department_id, employee_name, gender, degree, birthday, telephone, address, position, division, date_joined) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DbUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, employee.getDepartment().getDepartmentId());
            ps.setString(2, employee.getEmployeeName());
            ps.setString(3, employee.getGender());
            ps.setString(4, employee.getDegree());
            ps.setDate(5,new Date(employee.getBirthday().getTime()));
            ps.setString(6, employee.getTelephone());
            ps.setString(7, employee.getAddress());
            ps.setString(8, employee.getPosition());
            ps.setString(9, employee.getDivision());
            ps.setDate(10, new Date(employee.getDateJoined().getTime()));

            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(ps);
            DbUtil.close(connection);
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String sql = "delete from employee where employee_id=?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, employeeId);

            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "update employee set department_id=?, employee_name=?, gender=?, degree=?, birthday=?, telephone=?, address=?, position=?, division=?, date_joined=? where employee_id=?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, employee.getDepartment().getDepartmentId());
            ps.setString(2, employee.getEmployeeName());
            ps.setString(3, employee.getGender());
            ps.setString(4, employee.getDegree());
            ps.setDate(5, new Date(employee.getBirthday().getTime()));
            ps.setString(6,employee.getTelephone());
            ps.setString(7, employee.getAddress());
            ps.setString(8, employee.getPosition());
            ps.setString(9, employee.getDivision());
            ps.setDate(10, new Date(employee.getDateJoined().getTime()));
            ps.setInt(11, employee.getEmployeeId());

            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
    }

    @Override
    public List<Employee> findEmployeeList(int pageNum, int pageSize) {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from (")
                .append("select rownum as rn,t.*")
                .append("from (")
                    .append("select e.*,d.department_name from employee e left join department d on e.department_id=d.department_id ")
                    .append(")t where rownum <= ? ")
            .append(") where rn > ? ");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Employee> employeeList = new ArrayList<>();

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(String.valueOf(sb));
            ps.setInt(1,pageNum*pageSize);
            ps.setInt(2, (pageNum-1)*pageSize);

            rs = ps.executeQuery();
            while (rs.next()) {
                /**
                 * 此处字段较多该用单例+工厂+原型改造
                 * @author Mr.Longyx
                 * @date 2020/7/24 0:02
                 * @param pageNum
                 * @param pageSize
                 * @return java.util.List<com.spdb.study.hrs.hr4.dataobject.Employee>
                 */
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setEmployeeName(rs.getString("employee_name"));
                employee.setGender(rs.getString("gender"));
                employee.setDegree(rs.getString("degree"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setTelephone(rs.getString("telephone"));
                employee.setAddress(rs.getString("address"));
                employee.setPosition(rs.getString("position"));
                employee.setDivision(rs.getString("division"));
                employee.setDateJoined(rs.getDate("date_joined"));

                Department department = new Department();
                department.setDepartmentName(rs.getString("department_name"));

                employee.setDepartment(department);

                employeeList.add(employee);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(rs);
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
        return employeeList;
    }

    @Override
    public List<Employee> findEmployeeList() {
        return findEmployeeList(1, Integer.MAX_VALUE);
    }

}
