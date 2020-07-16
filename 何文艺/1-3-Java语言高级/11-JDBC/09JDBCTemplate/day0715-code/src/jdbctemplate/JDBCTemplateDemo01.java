package jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

/**
 * @program: TODO
 * @className:JDBCTemplateDemo01
 * @description:JDBCTemplate快速入门
 * @author: 何文艺
 * @create: 2020/7/16 11:35
 **/
public class JDBCTemplateDemo01 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql = "update account set balance = 5999 where id = ?";
        int count = template.update(sql,1);
        System.out.println(count);
    }
}
