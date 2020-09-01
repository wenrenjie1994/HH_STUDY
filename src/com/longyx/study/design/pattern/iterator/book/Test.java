package com.spdb.study.design.pattern.iterator.book;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 13:29
 */
public class Test {
    public static void main(String[] args) {
        Book book = new Book("Linux内核原理");
        Book book1 = new Book("高性能MySQL");
        Book book2 = new Book("算法与数据结构");
        Book book3 = new Book("设计模式");

        BookAggregate aggregate = new BookAggregateImpl();
        aggregate.add(book);
        aggregate.add(book1);
        aggregate.add(book2);
        aggregate.add(book3);

        System.out.println("=========书籍列表===============");
        printBookList(aggregate);

        aggregate.remove(book2);
        System.out.println("===========删除操作后的书籍列表==========");
        printBookList(aggregate);
    }

    private static void printBookList(BookAggregate aggregate) {
        Iterator<Book> iterator = aggregate.iterator();
        while (iterator.hashNext()){
            Book next = iterator.next();
            System.out.println("《"+next.getName()+"》");
        }
    }
}
