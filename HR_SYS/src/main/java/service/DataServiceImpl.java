package service;

import bean.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataServiceImpl implements DataService{
    @Override
    public List<Book> loadData(String fileName){
        List<Book> bookList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String data = reader.readLine();
            while(data != null){
                String[] datas = data.split(",");
                String bookName = datas[0];
                String bookAuthor = datas[1];
                double bookPrice =  Double.parseDouble(datas[2]);
                Book book = new Book(bookName, bookAuthor, bookPrice);
                bookList.add(book);
                data = reader.readLine();
            }
        }catch (FileNotFoundException notFoundException){
            try {
                new File(fileName).createNewFile();
                return bookList;
            }catch (IOException ioExcep){
                ioExcep.printStackTrace();
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        finally {
            if(reader != null)
                try {
                    reader.close();
                }catch (IOException ioException){
                    ioException.printStackTrace();
                }
        }
        return bookList;
    }

    @Override
    public void saveData(List<Book> bookList, String fileName){
        PrintWriter writer = null;
        try{
            writer = new PrintWriter(fileName);
            for(Book book : bookList){
                String bookInformation = book.getBookName()+","+book.getBookAuthor()+","+book.getBookPrice();
                writer.println(bookInformation);
            }
            writer.flush();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        finally {
            if(writer != null)
                writer.close();
        }
    }
}
