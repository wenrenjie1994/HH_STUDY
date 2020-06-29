package com.spdb.study.design.pattern.template.jdbc;

import java.sql.ResultSet;

/**
 * 模拟JDBC操作(查询)
 * ORM映射定制化的接口(通过RowMap进行不同结果的微调)
 * @author Mr.Longyx
 * @date 2020年06月29日 20:39
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
