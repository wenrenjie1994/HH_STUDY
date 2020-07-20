package bean;

public class Book {
    private String bookName;
    private String bookWriter;
    private double bookPrice;


    public Book(String bookName,String bookWriter,double bookPrice){
        this.bookName=bookName;
        this.bookWriter=bookWriter;
        this.bookPrice=bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookWriter='" + bookWriter + '\'' +
                ", bookPrice=" + bookPrice +
                '}';
    }
}
