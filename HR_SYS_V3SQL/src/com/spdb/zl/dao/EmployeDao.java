package com.spdb.zl.dao;

import com.spdb.zl.bean.Employe;
import com.spdb.zl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EmployeDao {
    public static void main(String[] args) throws SQLException {
        EmployeDao employeDao = new EmployeDao();
//        employeDao.createTable();
    }

    public void createTable() throws SQLException {

        JDBCUtil.getInstance();

        Connection con = JDBCUtil.getConnection();

        Statement st= con.createStatement();

        String sql = "create table employe (id bigint(3) primary key auto_increment,username varchar(9),age int(3),sex varchar(2),university varchar(100))";
        st.executeUpdate(sql);

        JDBCUtil.release(null, st, con);
    }

    public void addEmploye(Employe emp) throws SQLException {
        JDBCUtil.getInstance();

        Connection con = JDBCUtil.getConnection();

        String sql = "insert into employe (username,age,sex,university) values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, emp.getName());
        ps.setString(2, emp.getAge());
        ps.setString(3, emp.getSex());
        ps.setString(4, emp.getUniversity());

        ps.executeUpdate();

        JDBCUtil.release_new(null, ps, con);
    }

    public void saveEmploye(List<Employe> list){
    }

    public List<Employe> parseTxt(){
        return null;
    }

}
