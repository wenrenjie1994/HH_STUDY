package com.spdb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spdb.mapper.BookMapper;
import com.spdb.pojo.domain.Book;
import com.spdb.response.Response;
import com.spdb.service.BookService;
import com.spdb.util.ObjTool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.spdb.emun.ResponseMessage.*;

/**
 * @author liwenyi
 * @date 2020/7/13
 * desc:
 */
@Service("BookService")
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public Response insert(Book book) {
        Date date = new Date();
        book.setCreateTime(date);
        book.setModifiedTime(date);
        int res = bookMapper.insert(book);
        return res==1?new Response().success(book):new Response().failure(INSERT_ERROR);
    }

    @Override
    public Response modify(Book book) {
        Date date = new Date();
        book.setModifiedTime(date);
        int res = bookMapper.updateById(book);
        return res==1?new Response().success(book):new Response().failure(UPDATE_ERROR);
    }

    @Override
    public Response deleteById(Integer id) {
        int res = bookMapper.deleteById(id);
        return res==1?new Response().success(id):new Response().failure(DELETE_ERROR);
    }

    @Override
    public Response getBookById(Integer id) {
        return new Response().success(bookMapper.selectById(id));
    }

    @Override
    public Response getBooks(Integer page, Integer limit, String keywords) {
        //创建条件构造器
        QueryWrapper<Book> queryWrapper =new QueryWrapper<>();
        //判断是否传入关键字
        if (ObjTool.isNotNull(keywords)){
            //对书名、作者以及图书简介进行关键字匹配
            queryWrapper.like("book_name",keywords).or().
                    like("author",keywords).or().
                    like("book_desc",keywords);
        }
        queryWrapper.orderByDesc("modified_time");
        IPage<Book> bookPageInfo =bookMapper.selectPage(new Page<>(page,limit)
                ,queryWrapper);
        return new Response<>().success(bookPageInfo);
    }
}
