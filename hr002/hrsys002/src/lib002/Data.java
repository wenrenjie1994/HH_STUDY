package lib002;


import java.io.*;
import java.util.LinkedList;

/**
 * @program: hr002
 * @description: IO流读取，存储文件
 * @author: Victor(LAI Wentao)
 * @create: 2020-07-16 20:18
 */
public class Data {
    public  static void loadData(LinkedList<employee> elinkedList)  {
        BufferedReader br = null;
        //抛出异常
        try{
            br = new BufferedReader(new FileReader("E:/java/idea/workcode/hr002/hrsys002/src/lib002/elinkedList.txt"));
            //先new出BufferReader对象
            //File类传递给BufferedReader

            String D = br.readLine();      //用readLine读取文件内容
            while(D!=null){
                String[] str =D.split(",");  //split() 方法用于把一个字符串分割成字符串数组
                String name = str[0];
                String age = str[1];
                String sex = str[2];
                String home = str[3];
                String entry = str[4];
                employee e = new employee(name,age,sex,home,entry);
                elinkedList.add(e);  //添加到elinkedList
                D = br.readLine();
            }
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        finally {
            try{
                br.close();   //清空缓冲
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void saveData(LinkedList<employee> elinkedList){
        PrintWriter pw = null;
        try{
            pw = new PrintWriter("E:/java/idea/workcode/hr002/hrsys002/src/lib002/elinkedList.txt");
            for (int i = 0; i <elinkedList.size() ; i++) {
                pw.println(elinkedList.get(i).name+","+elinkedList.get(i).age
                        +","+elinkedList.get(i).sex+","+elinkedList.get(i).home
                        +","+elinkedList.get(i).entry);
            }
            pw.flush();//清空缓冲
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        finally {
            pw.close();
        }
    }
}

