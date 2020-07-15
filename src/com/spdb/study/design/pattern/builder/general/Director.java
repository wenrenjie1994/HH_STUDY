package com.spdb.study.design.pattern.builder.general;

/**
 * 具体调用者
 * @author Mr.Longyx
 * @date 2020年07月15日 8:49
 */
public class Director {
    public static void main(String[] args) {
        Book book = new Book();
        book.setName("设计模式在Spring中的应用");
        book.setAuthor("Komi");
        book.setPrice(99.99);
        
        Builder builder = new ConcreteBuilder(book);
        System.out.println(builder.build());
    }
}
