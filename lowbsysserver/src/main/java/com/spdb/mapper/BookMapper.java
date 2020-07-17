package com.spdb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spdb.pojo.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by liwenyi
 * Date: 2020/7/13
 * Desc:
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
