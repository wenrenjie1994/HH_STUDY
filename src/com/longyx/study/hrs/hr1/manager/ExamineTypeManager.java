package com.longyx.study.hrs.hr1.manager;

import com.longyx.study.hrs.hr1.dataobject.ExamineType;
import com.longyx.study.hrs.hr1.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 考核类别管理类
 * @author Mr.Longyx
 * @date 2020年07月21日 15:43
 */
public class ExamineTypeManager {
    /**
     * 静态私有成员变量
     * @author Mr.Longyx
     * @date 2020/7/21 15:57
     */
    private static volatile ExamineTypeManager INSTANCE = null;
    /**
     * 构造方法私有化
     * @author Mr.Longyx
     * @date 2020/7/21 15:58
     */
    private ExamineTypeManager(){}

    /**
     * 提供全局访问点
     * @author Mr.Longyx
     * @date 2020/7/21 15:58
     */
    public static ExamineTypeManager getInstance() {
        if (INSTANCE == null) {
            synchronized (ExamineTypeManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ExamineTypeManager();
                }
            }
        }
        return INSTANCE;
    }
    /**
     * 增加考核方式
     * @author Mr.Longyx
     * @date 2020/7/21 15:44
     * @param examineTypeName
     */
    public void addExamineType(String examineTypeName) {
        String sql = "insert into examine_type(examine_type_name) values(?) ";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DbUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,examineTypeName);

            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtil.close(ps);
            DbUtil.close(connection);
        }
    }

    /**
     * @author Mr.Longyx
     * @date 2020/7/21 16:48
     * @return java.util.List<com.longyx.study.hrs.hr1.dataobject.ExamineType>
     */
    public List<ExamineType> findExamineTypes(){
        String sql = "select * from examine_type order by examine_type_id";
        Connection conn = null;
        PreparedStatement ps = null;

        List<ExamineType> examineTypes = new ArrayList<>();
        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int examineTypeId = result.getInt("examine_type_id");
                String examineTypeName = result.getString("examine_type_name");

                ExamineType examineType = new ExamineType();
                examineType.setExamineTypeId(examineTypeId);
                examineType.setExamineTypeName(examineTypeName);

                examineTypes.add(examineType);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
        return examineTypes;
    }

    /**
     * 根据考核类型Id删除考核类型
     * @author Mr.Longyx
     * @date 2020/7/21 18:18
     * @param examineTypeId
     */
    public void delExamineType(int examineTypeId){
        String sql = "delete from examine_type where examine_type_id=?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtil.getConnection();
            ps =  conn.prepareStatement(sql);
            ps.setInt(1,examineTypeId);

           ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
    }

    public void updateExamineType(int examineTypeId, String examineTypeName) {
        String sql = "update examine_type set examine_type_name=? where examine_type_id=?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtil.getConnection();
            ps =  conn.prepareStatement(sql);
            ps.setString(1,examineTypeName);
            ps.setInt(2,examineTypeId);

            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(ps);
            DbUtil.close(conn);
        }
    }

}
