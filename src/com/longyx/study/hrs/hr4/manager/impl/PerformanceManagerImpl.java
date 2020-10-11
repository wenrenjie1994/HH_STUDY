package com.longyx.study.hrs.hr4.manager.impl;

import com.longyx.study.hrs.hr3.util.DbUtil;
import com.longyx.study.hrs.hr4.dataobject.Department;
import com.longyx.study.hrs.hr4.dataobject.Employee;
import com.longyx.study.hrs.hr4.dataobject.ExamineType;
import com.longyx.study.hrs.hr4.dataobject.Performance;
import com.longyx.study.hrs.hr4.manager.PerformanceManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年07月25日 13:28
 */
public class PerformanceManagerImpl implements PerformanceManager {
    @Override
    public void addPerformance(Performance performance) {
        String sql = "insert into performance(employee_id, examine_type_id,evaluation_items,grade,ratings) values(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, performance.getEmployeeId());
            ps.setInt(2, performance.getExamineTypeId());
            ps.setString(3, performance.getEvaluationItems());
            ps.setDouble(4, performance.getGrade());
            ps.setString(5, performance.getRatings());

            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
    }

    @Override
    public void updatePerformance(Performance performance) {
        String sql = "update performance set grade=? where employee_id=? and examine_type_id=?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, performance.getGrade());
            ps.setInt(2, performance.getEmployeeId());
            ps.setInt(3, performance.getExamineTypeId());

            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
    }

    @Override
    public void deletePerformance(int employeeId, int examineTypeId) {
        String sql = "delete from performance where employee_id=? and examine_type_id=?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, employeeId);
            ps.setInt(2, examineTypeId);

            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
    }

    /**
     * 根据员工Id查询员工绩效
     * @author Mr.Longyx
     * @date 2020/7/25 18:59
     * @param employeeId
     * @return java.util.List<com.longyx.study.hrs.hr4.dataobject.Performance>
     */
    @Override
    public List<Performance> findPerformanceListByEmployeeId(int employeeId) {
        StringBuffer sb = new StringBuffer();;
        sb.append("select p.employee_id,e.employee_name,d.department_name,ex.examine_type_name,p.grade ")
                .append("from performance p left join employee e on p.employee_id=e.employee_id ")
                .append("left join department d on e.department_id=d.department_id ")
                .append("left join examine_type ex on p.examine_type_id = ex.examine_type_id ")
                .append("where p.employee_id=?");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Performance> performanceList = new ArrayList<>();
        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(String.valueOf(sb));
            ps.setInt(1, employeeId);

            rs = ps.executeQuery();
            performanceList = getPerformanceList(rs);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(rs);
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
        return performanceList;
    }

    @Override
    public List<Performance> findHigherPerformanceList() {
        StringBuffer sb = new StringBuffer();
        sb.append("select e.employee_id,e.employee_name,d.department_name,ex.examine_type_name,p.grade ")
                .append("from performance p left join employee e on p.employee_id=e.employee_id ")
                .append("left join department d on e.department_id=d.department_id ")
                .append("left join examine_type ex on p.examine_type_id=ex.examine_type_id ")
                .append("where p.grade in ")
                .append("(")
                    .append("select max(pr.grade) from performance pr where pr.examine_type_id=ex.examine_type_id ")
                .append(")");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Performance> performanceList = new ArrayList<> ();
        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(String.valueOf(sb));

            rs = ps.executeQuery();
            performanceList = getPerformanceList(rs);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(rs);
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
        return performanceList;
    }

    @Override
    public List<Performance> findPerformanceListTop3() {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from ")
                .append("(")
                    .append("select p.employee_id,e.employee_name,d.department_name,sum(p.grade) total_grade ")
                    .append("from performance p left join employee e on p.employee_id=e.employee_id ")
                    .append("left join department d on e.department_id=d.department_id ")
                    .append("group by p.employee_id,e.employee_name,d.department_name ")
                    .append("order by total_grade desc ")
                .append(") where rownum <= ? ");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Performance> performanceList = new ArrayList<>();
        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(String.valueOf(sb));
            ps.setInt(1, 3);

            rs = ps.executeQuery();
            while (rs.next()) {
                Performance performance = new Performance();
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setEmployeeName(rs.getString("employee_name"));

                //部门
                Department department = new Department();
                department.setDepartmentName(rs.getString("department_name"));

                /**
                 * 建立员工和部门的关联
                 * @author Mr.Longyx
                 * @date 2020/7/25 19:09
                 * @param employeeId
                 * @return java.util.List<com.longyx.study.hrs.hr4.dataobject.Performance>
                 */
                employee.setDepartment(department);

                //建立绩效和员工的关联
                performance.setEmployee(employee);

                performance.setGrade(rs.getFloat("total_grade"));

                performanceList.add(performance);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(rs);
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
        return performanceList;
    }

    @Override
    public List<Performance> findPerformanceList(int pageNum, int pageSize) {
        StringBuffer sb = new StringBuffer();
        sb.append("select employee_id,employee_name,department_name,examine_type_name,grade from ")
                .append("(")
                    .append("select rownum as rn, employee_id,employee_name,department_name,examine_type_name,grade from ")
                        .append("(")
                            .append("select p.employee_id,e.employee_name,d.department_name,ex.examine_type_name,p.grade ")
                            .append("from performance p left join employee e on p.employee_id=e.employee_id ")
                            .append("left join department d on e.department_id=d.department_id ")
                            .append("left join examine_type ex on p.examine_type_id = ex.examine_type_id order by p.employee_id,p.examine_type_id ")
                        .append(") where rownum <=? ")
                .append(") where rn > ? ");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Performance> performanceList = new ArrayList<>();
        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(String.valueOf(sb));
            ps.setInt(1, pageNum*pageSize);
            ps.setInt(2, (pageNum-1)*pageSize);

            rs = ps.executeQuery();
            performanceList = getPerformanceList(rs);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(rs);
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
        return performanceList;
    }

    private List<Performance> getPerformanceList(ResultSet rs) throws Exception {
        List<Performance> performanceList = new ArrayList<>();

        while (rs.next()) {
            Performance performance = new Performance();
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employee_id"));
            employee.setEmployeeName(rs.getString("employee_name"));

            //部门
            Department department = new Department();
            department.setDepartmentName(rs.getString("department_name"));

            /**
             * 建立员工和部门的关联
             * @author Mr.Longyx
             * @date 2020/7/25 19:09
             * @param employeeId
             * @return java.util.List<com.longyx.study.hrs.hr4.dataobject.Performance>
             */
            employee.setDepartment(department);

            //建立绩效和员工的关联
            performance.setEmployee(employee);

            ExamineType examineType = new ExamineType();
            examineType.setExamineTypeName(rs.getString("examine_type_name"));

            //建立绩效和考核类别的关联
            performance.setExamineType(examineType);

            performance.setGrade(rs.getFloat("grade"));

            performanceList.add(performance);
        }
        return performanceList;
    }
}
