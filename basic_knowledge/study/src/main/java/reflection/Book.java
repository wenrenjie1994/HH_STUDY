package reflection;

import lombok.Data;

/**
 * @author: chenlei
 * @date: 17:28 2020/6/12
 **/
@Data
public class Book {
    private final static String TAG = "BookTag";


    private String name;
    private String author;

    public Book(){}
    public Book(String name,String author){
        this.name = name;
        this.author = author;
    }

    private String getInfo(){
        return "Name:" + name + ",author:" + author;
    }
    public String getName() {
        return this.name;
    }
}
