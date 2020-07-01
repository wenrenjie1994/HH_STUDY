package com.jinjie.sun.dao;

import com.jinjie.sun.dao.HRDao;
import com.jinjie.sun.pojo.HR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HRDaoImpl implements HRDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(HR hr) {
        return jdbcTemplate.update("insert into hr(name, username, password, phone, addr) values(?, ?, ?, ?, ?)",
                hr.getName(), hr.getUsername(), hr.getPassword(), hr.getPhone(), hr.getAddr());
    }

    @Override
    public int update(HR hr) {
        return jdbcTemplate.update("update hr set name = ?, password = ?, phone = ?, addr = ? where id = ?",
                new Object[]{hr.getName(), hr.getPassword(), hr.getPhone(), hr.getAddr(), hr.getId()});
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from hr where id = ?", id);
    }

    @Override
    public HR findHR(Long id) {
        List<HR> list = jdbcTemplate.query("select * from hr where id = ?", new Object[]{id}, new BeanPropertyRowMapper<HR>(HR.class));
        if (null != list && list.size() > 0) {
            HR hr = list.get(0);
            return hr;
        } else {
            return null;
        }
    }

    @Override
    public List<HR> findHRList() {
        List<HR> list = jdbcTemplate.query("select * from hr", new Object[]{}, new BeanPropertyRowMapper<HR>(HR.class));
        return list;
    }
}
