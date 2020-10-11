package com.longyx.study.design.pattern.builder.general;

/**
 * 具体建造者
 * @author Mr.Longyx
 * @date 2020年07月15日 8:46
 */
public class ConcreteBuilder implements Builder{

    private Book book;

    public ConcreteBuilder(Book book){
        this.book = book;
    }

    @Override
    public Book build() {
        return book;
    }
}
