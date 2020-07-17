package service;


import model.Resume;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenlei
 * @Date: 2020/7/15 14:30
 */
public class DatabaseService {
    private static Logger logger = LogManager.getLogger(DatabaseService.class);
    private static Connection connection = MySQLUtil.getConnection();


    /**
     * 查询数据
     * @param name
     * @return
     */
    static Resume selectByName(String name) {
        if(name != null && !"".equals(name)) {
            String sql = "select * from resume where name = ?";
            try {
                //PreparedStatement 能够防止sql注入
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,name);
                ResultSet result = statement.executeQuery();
                if(result.next()) {
                    return new Resume(result.getString("name"),result.getInt("year"),result.getString("job"));
                }else {
                    logger.info("该用户不存在");
                    return null;
                }
            }catch (SQLException e) {
                logger.debug("sql 语句错误");
                e.printStackTrace();
            }
        }
        return null;
    }

    static List<Resume> selectAllResume() {
        ArrayList<Resume> resumeArrayList = new ArrayList<>();
        String sql = "select * from resume";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Resume re = new Resume(resultSet.getString("name"),resultSet.getInt("year"),resultSet.getString("job"));
                resumeArrayList.add(re);
            }
        }catch (SQLException e) {
            logger.debug("SQL 语句错误");
        }
        logger.info("数据数据共有" + resumeArrayList.size() + "条");
        return resumeArrayList;
    }

    static boolean addResume(Resume resume) {
        long s = 0;
        if(resume != null) {
            String sql = "insert into resume(name,job,year) values(?,?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,resume.getName());
                statement.setString(2,resume.getJob());
                statement.setInt(3,resume.getYear());
                s = statement.executeLargeUpdate();
                System.out.println(s);
            }catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            logger.info("参数错误");
            return false;
        }
        return s != 0;
    }

    static boolean deleteResume(String name) {
        long s = 0;
        if(name != null && !"".equals(name)) {
            String sql = "delete from resume where name = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,name);
                s = statement.executeUpdate();
                System.out.println(s);
            }catch (SQLException e) {
                e.printStackTrace();
                logger.debug("SQL错误");
            }
        }else{
            logger.info("参数错误");
        }
        return s != 0;
    }

    static boolean updateResume(Resume resume) {
        long s = 0;
        if(resume != null) {
            String sql = "update resume set year = ?,job = ? where name = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,resume.getYear());
                statement.setString(2,resume.getJob());
                statement.setString(3,resume.getName());
                s = statement.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();
                logger.debug("SQL错误");
            }
        }else{
            logger.info("参数错误");
        }
        return s != 0;
    }

}
