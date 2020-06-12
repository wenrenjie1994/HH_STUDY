package com.liujinji.serviceonline.data;

import com.liujinji.serviceonline.ServiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcServiceItemRepository implements ServiceItemRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcServiceItemRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<ServiceItem> findAll() {
        return jdbc.query("select id, contain, type from ServiceItem",
                //使用Lambda方法将RowMapper转换为对象
                this::mapRowToServiceItem);
    }

    @Override
    public ServiceItem findOne(String id) {
        return jdbc.queryForObject("select id, contain, type from ServiceItem where id=?",
                //使用显式方法将RowMapper转换为对象
                new RowMapper<ServiceItem>() {
                    @Override
                    public ServiceItem mapRow(ResultSet rs, int i) throws SQLException {
                        return new ServiceItem(
                                rs.getString("id"),
                                rs.getString("contain"),
                                ServiceItem.Type.valueOf(rs.getString("type")));
                    }
                }, id);
    }

    @Override
    public ServiceItem save(ServiceItem serviceItem) {
        jdbc.update("insert into ServiceItem (id, contain, type ) values (?,?,?)",
                serviceItem.getId(),
                serviceItem.getContain(),
                serviceItem.getType().toString());
        return serviceItem;
    }

    // 结果集转到对象
    private ServiceItem mapRowToServiceItem(ResultSet rs, int rowNum) throws SQLException {
        return new ServiceItem(
                rs.getString("id"),
                rs.getString("contain"),
                ServiceItem.Type.valueOf(rs.getString("type")));
    }
}
