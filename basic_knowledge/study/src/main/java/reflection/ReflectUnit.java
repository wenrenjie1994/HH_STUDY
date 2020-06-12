package reflection;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: chenlei
 * @date: 17:46 2020/6/12
 **/
public class ReflectUnit {
    //创建对象
    public static Book instanceBook() {
        try {
            Class<?> classBook = Class.forName("reflection.Book");
            //newInstance()方法已经弃用，应该使用如下方法来生成对象
            Object objectBook = classBook.getDeclaredConstructor().newInstance();
            Book book = (Book)objectBook;
            book.setAuthor("鲁迅");
            book.setName("呐喊");
            System.out.println("class"+book.toString());
            return book;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反射属性
    public static void reflectField(Book book,String field) {
        try {
            Class<?> classBook = Class.forName("reflection.Book");
            Field fieldTag = classBook.getDeclaredField(field);
            fieldTag.setAccessible(true);
            String name = (String)fieldTag.get(book);
            System.out.println("name:" + name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //反射方法
    public static void reflectMethod(Book book,String m) {
        try {
            Class<?> classBook = Class.forName("reflection.Book");
            Method method = classBook.getMethod(m);
            method.setAccessible(true);
            String s = (String) method.invoke(book);
            System.out.println("method:" + s);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Book book = instanceBook();
        reflectField(book,"name");
        reflectMethod(book,"getInfo");
    }
}
