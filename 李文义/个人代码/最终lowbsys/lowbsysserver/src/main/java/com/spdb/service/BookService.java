package com.spdb.service;

import com.spdb.pojo.domain.Book;
import com.spdb.response.Response;

/**
 * @author liwenyi
 * @date 2020/7/13
 * desc:
 */
public interface BookService {

    /**
     * 功能描述:
     * 插入图书信息
     *
     * @param book 图书信息
     * @return: com.spdb.response.Response
     * @author: liwenyi
     */
    Response insert(Book book);

    /**
     * 功能描述:
     * 修改图书信息
     *
     * @param book 图书信息
     * @return: com.spdb.response.Response
     * @author: liwenyi
     */
    Response modify(Book book);

    /**
     * 功能描述:
     * 删除图书信息
     *
     * @param id 图书id
     * @return: com.spdb.response.Response
     * @author: liwenyi
     */
    Response deleteById(Integer id);

    /**
     * 功能描述:
     * 根据id查询图书信息
     *
     * @param id 1
     * @return: com.spdb.response.Response
     * @author: liwenyi
     */
    Response getBookById(Integer id);

    /**
     * 功能描述:
     * 分页查询图书信息列表
     *
     * @param page     1
     * @param limit    2
     * @param keywords 3
     * @return: com.spdb.response.Response
     * @author: liwenyi
     */
    Response getBooks(Integer page, Integer limit, String keywords);
}
