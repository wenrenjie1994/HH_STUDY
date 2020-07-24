/*
* 书这个类的属性
* */

package Model;

public class Book {
    public String Bookname;
    public String BookAuthor;
    public float BookPrice;
    public Book(String name,String Author,float Price){
        this.Bookname = name;
        this.BookAuthor = Author;
        this.BookPrice = Price;
    }
}
