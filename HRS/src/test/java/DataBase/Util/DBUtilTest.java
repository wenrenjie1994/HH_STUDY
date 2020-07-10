package DataBase.Util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @author：liujinji0452@gmail.com
 * @time: 2020/7/10 23:32
 */
public class DBUtilTest {
    @Test
    public void connectionTest() throws SQLException {
        ResultSet rs = DBUtil.runQuery("select * from tblstudent");
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        DBUtil.releaseAll();
    }

}