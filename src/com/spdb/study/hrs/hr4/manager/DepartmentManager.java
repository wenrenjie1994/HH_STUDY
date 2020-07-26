package com.spdb.study.hrs.hr4.manager;

import com.spdb.study.hrs.hr4.dataobject.Department;
import com.spdb.study.hrs.hr4.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 部门管理类(静态内部类单例写法)
 * @author Mr.Longyx
 * @date 2020年07月21日 20:53
 */
public class DepartmentManager {
    /**
     * 私有化构造方法
     * @author Mr.Longyx
     * @date 2020/7/21 20:55
     */
    private DepartmentManager(){
        if (InnerClassHolder.INSTANCE != null) {
            throw new RuntimeException("不允许构建多个实例");
        }
    }

    /**
     * 全局访问点
     * @author Mr.Longyx
     * @date 2020/7/21 20:56
     */
    public static DepartmentManager getInstance() {
        return InnerClassHolder.INSTANCE;
    }

    /**
     * 静态内部类
     * @author Mr.Longyx
     * @date 2020/7/21 21:01
     */
    private static class InnerClassHolder {
        private static final DepartmentManager INSTANCE = new DepartmentManager();
    }

    /**
     * 获取部门信息
     * @author Mr.Longyx
     * @date 2020/7/21 21:11
     */
    public void getDepartments(){
        Connection conn = null;
        try {
            conn = DbUtil.getConnection();
            getDepartments(conn, 0, 0);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn);
        }
    }

    /**
     * 递归读取部门树形结构
     * @author Mr.Longyx
     * @date 2020/7/21 21:15
     * @param conn
     * @param deptId
     * @param level
     */
    private void getDepartments(Connection conn, int deptId, int level) throws SQLException {
        String sql = "select * from department where pid=?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        String s = "";
        try {
            for (int i = 0; i< level; ++i) {
                s += "  ";
            }

            ps = conn.prepareStatement(sql);
            ps.setInt(1, deptId);

            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(s + rs.getInt("department_id") + " 【"+ rs.getString("department_name") +"】 ");
                /**
                 * 非叶子节点
                 * @author Mr.Longyx
                 * @date 2020/7/21 21:29
                 * @param conn
                 * @param deptId
                 * @param level
                 */
                if (rs.getInt("leaf") == 0) {
                    getDepartments(conn, rs.getInt("department_id"), level+1);
                }
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(ps);
        }
    }

    /**
     * 添加部门
     * @author Mr.Longyx
     * @date 2020/7/21 22:18
     * @param pid
     * @param departmentName
     */
    public void addDepartment(int pid, String departmentName){
        String sql = "insert into department(pid, department_name) values(?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtil.getConnection();
            //手动控制事务
            DbUtil.setAutoCommit(conn,false);

            ps = conn.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.setString(2, departmentName);
            ps.executeUpdate();

            /**
             * 获取当前节点的父节点
             * @author Mr.Longyx
             * @date 2020/7/21 22:40
             * @param pid
             * @param deptName
             */
            Department parentDepartment = findDepartmentById(pid);
            /**
             * 叶子
             * @author Mr.Longyx
             * @date 2020/7/21 22:42
             * @param pid
             * @param deptName
             */
            if (parentDepartment.getLeaf() == 1) {
                //修改为非叶子
                updateLeaf(conn, parentDepartment.getDepartmentId(), 0);
            }

            DbUtil.commit(conn);
        }catch (Exception e) {
            e.printStackTrace();
            DbUtil.rollback(conn);
        }finally {
            DbUtil.close(ps);
            /**
             * 恢复连接的最初状态：自动提交
             * @author Mr.Longyx
             * @date 2020/7/22 14:24
             * @param pid
             * @param departmentName
             */
            DbUtil.setAutoCommit(conn, true);
            DbUtil.close(conn);
        }
    }

    /**
     * 更新Leaf字段
     * @author Mr.Longyx
     * @date 2020/7/21 22:44
     * @param conn
     * @param departmentId
     * @param leaf 目标值 1/0
     */
    private void updateLeaf(Connection conn, int departmentId, int leaf) throws SQLException {
        String sql = "update department set leaf = ? where department_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, leaf);
            ps.setInt(2, departmentId);

            ps.executeUpdate();
        }finally {
            DbUtil.close(ps);
        }
    }

    /**
     * 根据Id查询部门
     * @author Mr.Longyx
     * @date 2020/7/21 22:28
     * @param departmentId
     * @return com.spdb.study.hrs.hr2.dataobject.Department
     */
    public Department findDepartmentById(int departmentId) {
        String sql = "select * from department where department_id=?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Department department = null;
        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, departmentId);
            rs = ps.executeQuery();

            if (rs.next()) {
                department = new Department();
                department.setDepartmentId(departmentId);
                department.setDepartmentName(rs.getString("department_name"));
                department.setPid(rs.getInt("pid"));
                department.setLeaf(rs.getInt("leaf"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtil.close(rs);
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
        return department;
    }


    /**
     * 修改部门
     * @author Mr.Longyx
     * @date 2020/7/22 19:07
     */
    public void updateDepartment(int departmentId, String departmentName) {
        String sql = "update department set department_name=? where department_id=?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,departmentName);
            ps.setInt(2,departmentId);
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
    }

    /**
     * 根据部门Id删除部门
     * @author Mr.Longyx
     * @date 2020/7/22 19:14
     */
    public void deleteDepartments(int departmentId){
        Connection conn = null;
        try {
            conn = DbUtil.getConnection();

            DbUtil.setAutoCommit(conn, false);

            /**
             * 根据departmentId取得部门对象
             * @author Mr.Longyx
             * @date 2020/7/22 21:06
             * @param departmentId
             */
            Department departments = findDepartmentById(departmentId);

            /**
             * 递归删除部门
             * @author Mr.Longyx
             * @date 2020/7/22 21:07
             * @param departmentId
             */
            deleteDepartments(conn, departmentId);

            /**
             * 返回子节点个数
             * @author Mr.Longyx
             * @date 2020/7/22 21:18
             * @param departmentId
             */
            int count = getChildren(conn, departments.getPid());
            /**
             * 如果不存在子节点
             * @author Mr.Longyx
             * @date 2020/7/22 21:28
             * @param departmentId
             */
            if (count == 0) {
                /**
                 *修改leaf为叶子
                 */
                updateLeaf(conn, departments.getPid(), 1);
            }

            //提交事务
            DbUtil.commit(conn);
        }catch (Exception e){
            e.printStackTrace();
            DbUtil.rollback(conn);
        }finally {
            DbUtil.close(conn);
        }
    }

    /**
     * 获取子节点个数
     * @author Mr.Longyx
     * @date 2020/7/22 21:20
     * @param conn
     * @param pid
     * @return int
     */
    private int getChildren(Connection conn, int pid) {
        String sql = "select count(*) from department where pid=?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        int count = 0;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pid);

            rs = ps.executeQuery();
            rs.next();
            /**
             * 重载方法，根据位置项获取字段名
             * @author Mr.Longyx
             * @date 2020/7/23 20:59
             */
            count = rs.getInt(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtil.close(rs);
            DbUtil.close(ps);
        }
        return count;
    }

    /**
     * 实现递归删除部门逻辑
     * @author Mr.Longyx
     * @date 2020/7/22 21:09
     */
    private void deleteDepartments(Connection conn, int departmentId) throws Exception {
        //先查询
        String sql = "select * from department where pid = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,departmentId);
            rs = ps.executeQuery();
            while (rs.next()) {
                //非叶子
                if (rs.getInt("leaf") == 0) {
                    deleteDepartments(conn, rs.getInt("department_id"));
                }
                //删除
                deleteDepartmentById(conn, rs.getInt("department_id"));
            }
            //删除自身
            deleteDepartmentById(conn, departmentId);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            DbUtil.close(rs);
            DbUtil.close(ps);
        }
    }

    /**
     * 删除具体的部门
     * @author Mr.Longyx
     * @date 2020/7/22 21:15
     * @param conn
     * @param departmentId
     */
    private void deleteDepartmentById(Connection conn, int departmentId) throws Exception {
        String sql = "delete from department where department_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, departmentId);
            ps.executeUpdate();
        }finally {
            DbUtil.close(ps);
        }
    }

    public static void main(String[] args) {
        DepartmentManager.getInstance().getDepartments();
    }
}
