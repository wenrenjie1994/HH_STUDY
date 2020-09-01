package com.spdb.study.design.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟自行实现JdbcTemplate操作(查询)
 * @author Mr.Longyx
 * @date 2020年07月01日 13:48
 */
public abstract class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql,RowMapper<?> mapper,Object[] values){
       try {
           //1、获取连接
           Connection conn = this.getConnection();
           //2、创建语句集
           PreparedStatement ps = this.createPrepareStatement(conn,sql);
           //3、执行语句集
           ResultSet rs = this.executeQuery(ps,values);
           //4、处理结果集
           List<?> result = this.parseResultSet(rs,mapper);
           //5、关闭结果集
           this.closeResultSet(rs);
           //6、关闭语句集
           this.closeStatement(ps);
           //7、关闭连接
           this.closeConnection(conn);

           //8、返回result
           return result;
       }catch (Exception e){
           e.printStackTrace();
       }
        return null;
    }

    protected  void closeConnection(Connection conn) throws Exception {
        conn.close();
    }

    protected  void closeStatement(PreparedStatement ps) throws Exception {
        ps.close();
    }

    protected  void closeResultSet(ResultSet rs) throws Exception {
        rs.close();
    }

    protected  List<?> parseResultSet(ResultSet rs,RowMapper<?> mapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 0;
        while (rs.next()){
            result.add(mapper.mapRow(rs,rowNum++));
        }
        return result;
    }

    protected ResultSet executeQuery(PreparedStatement ps,Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            ps.setObject(i,values[i]);
        }
        return ps.executeQuery();
    }
    protected PreparedStatement createPrepareStatement(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    }


    protected Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }
}
