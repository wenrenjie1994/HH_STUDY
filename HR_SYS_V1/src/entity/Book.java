package entity;

/**
 * @author：邓密文
 * @program:
 * @description:
 * @create: Created in 22:36 2020/7/6
 **/
public class Book {
    //这里修饰符用public合理吗？是否有更好的方式

    public String bookName;//书名
    public String bookAuthor;//书的作者
    public double bookPrice;//书的价格

    //有参构造函数
    public Book(String bookName,String bookAuthor,double bookPrice){
        this.bookName=bookName;
        this.bookAuthor=bookAuthor;
        this.bookPrice=bookPrice;
    }
}
