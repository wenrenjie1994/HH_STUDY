package dao;
/*
   调用数据库
   实现增删改查功能
 */

import Domain.Resume;
import Tools.JDBCUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Dao {
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    /*
        1.增加简历信息
        不需要返回值，需要传递进来一个简历的对象
     */
    public void addResume(Resume resume){
        try {
            String sql = "INSERT INTO hr_resume (id,name,school,email)VALUES(?,?,?,?)";
            Object[] params = {resume.getId(),resume.getName(),resume.getSchool(),resume.getEmail()};
            qr.update(sql,params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("简历信息添加失败");
        }
    }
    /*
        2.修改简历信息
        不需要返回值，需要传递进来一个简历的对象
     */
    public void editResume(Resume resume){
        try {
            String sql = "UPDATE hr_resume SET NAME=?,school=?,email=? WHERE id=?";
            Object[] params = {resume.getName(),resume.getSchool(),resume.getEmail(),resume.getId()};
            qr.update(sql,params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("简历修改失败");
        }
    }

    /*
        3.删除简历信息
        不需要返回值，需要传递进来一个id
     */
    public void deleteResume(String id){
        try {
            String sql = "DELETE FROM hr_resume WHERE id = ?";
            qr.update(sql,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("删除简历失败");
        }
    }
    /*
        4.查询简历信息
        需要返回集合，分为全部查询和单个查询
     */
    /*
        查询所有学生的简历
        将结果存放到bean对象中，再存储到集合
     */
    public List<Resume> selectAll(){
        try {
            String sql = "SELECT * FROM hr_resume";
            //调用qr的query方法，将结果存放在BeanListHandler里(反射啥的，我还没搞懂)
            List<Resume> list = qr.query(sql, new BeanListHandler <> (Resume.class));
            return list;
        }catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException("查询简历信息失败");
        }
    }

    /*
        查询指定学生的简历
        将结果存放到bean对象中，再存储到集合
     */
    public List<Resume> select(String id){
        try {
            String sql = "SELECT * FROM hr_resume WHERE id = ?";
            //调用qr的query方法，将结果存放在BeanListHandler里(反射啥的，我还没搞懂)
            List<Resume> list = qr.query(sql, new BeanListHandler <> (Resume.class),id);
            return list;
        }catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException("条件查询失败");
        }
    }
}
