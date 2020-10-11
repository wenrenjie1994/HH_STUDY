package com.longyx.study.design.pattern.template.jdbc;

import java.sql.ResultSet;

/**
 * 通过RowMapper实现结果微调
 * ORM映射定制化的借口
 * @author Mr.Longyx
 * @date 2020年07月01日 13:49
 */
public interface RowMapper<T>{
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
