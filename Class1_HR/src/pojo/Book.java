package pojo;

public class Book {
    private String bookName;
    private String bookAuthor;
    public double bookPrice;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
    public Book(String bookName,String bookAuthor,Double bookPrice){
        this.bookAuthor = bookAuthor;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }
}
