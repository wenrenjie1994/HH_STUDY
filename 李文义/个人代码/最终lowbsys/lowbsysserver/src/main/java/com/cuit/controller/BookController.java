package com.cuit.controller;

import com.cuit.pojo.domain.Book;
import com.cuit.response.Response;
import com.cuit.service.BookService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author liwenyi
 * @date 2020/7/13
 * desc:
 */
@CrossOrigin(origins = "*")   //解决跨域问题
@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping("")
    public Response insert(@Valid @RequestBody Book book, BindingResult result){
        if (result.hasErrors()) {
            return new Response<>().failure(result);
        }
        return bookService.insert(book);
    }

    @PatchMapping("")
    public Response modify(@Valid @RequestBody Book book, BindingResult result){
        if (result.hasErrors()) {
            return new Response<>().failure(result);
        }
        return bookService.modify(book);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable(value = "id") Integer id){
        return bookService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Response getBookById(@PathVariable(value = "id") Integer id){
        return bookService.getBookById(id);
    }

    @GetMapping("")
    public Response getBooks(@RequestParam(name = "page") Integer page
            , @RequestParam(name = "limit") Integer limit
            , @RequestParam(name = "keywords",required = false) String keywords){
        return bookService.getBooks(page,limit,keywords);
    }
}
