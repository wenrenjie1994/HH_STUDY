package handledate;

import model.Person;

import java.io.*;
import java.util.LinkedList;

@SuppressWarnings("all")
public class Handle {
    /*//从txt文件中读取数据
    public static void readData(LinkedList<Person> peopleList)  {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:/Users/Administrator/Desktop/peopleList.txt"));
            String data = br.readLine();
            while (data!=null){
                String[] split = data.split(",");
                String personName = split[0];
                String  personID = split[1];
                String personClass = split[2];
                Person person = new Person(personName,personID,personClass);
                peopleList.add(person);
                data = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    //存放数据到txt文件中
    public static void saveData(LinkedList<Person> peopleList) throws FileNotFoundException {
        PrintWriter pw = null;
        pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:/Users/Administrator/Desktop/peopleList.txt",false)));
        int personCount = peopleList.size();
        for (int i = 0; i < personCount; i++) {
            System.out.println(peopleList.get(i).getPersonName()+","+peopleList.get(i).getPersonID()+","+peopleList.get(i).getPersonClass());
        }
        pw.flush();
        pw.close();
    }*/
    public static void readData(LinkedList<Person> bookList)
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("C:/Users/Administrator/Desktop/peopleList.txt"));
            String data = br.readLine();
            while(data!=null)
            {
                String[] str = data.split(",");
                String personName =str[0];
                String personID =str[1];
                String personClass =str[1];
                Person person = new Person(personName,personID ,personClass);
                bookList.add(person);
                data = br.readLine();
            }
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveData(LinkedList<Person> bookList)
    {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:/Users/Administrator/Desktop/peopleList.txt",false)));//覆盖写入
            int bookCount = bookList.size();
            for(int i=0;i<bookCount;i++)
            {
                printWriter.println(bookList.get(i).getPersonName()+","+bookList.get(i).getPersonID()+","+bookList.get(i).getPersonClass());
            }
            printWriter.flush();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            printWriter.close();
        }
    }
}
