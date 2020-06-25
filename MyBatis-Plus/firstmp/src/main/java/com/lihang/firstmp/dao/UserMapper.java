package com.lihang.firstmp.dao;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.lihang.firstmp.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/5/25
 */
public interface UserMapper extends BaseMapper<User>  {
  /*  @Select("select * from user ${ew.customSqlSegment}")*/
    List<User> selectAll(@Param(Constants.WRAPPER)Wrapper<User> wrapper);
}
