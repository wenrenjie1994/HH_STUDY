package loadandsaveData;

import java.io.*;
import java.util.LinkedList;
import control.Employee;

@SuppressWarnings("all")
public class DataOperate {
    public static void loadData(LinkedList<Employee> employeeList)
    {
        BufferedReader br = null;
        try
        {
         //创建BufferedReader对象
            br = new BufferedReader(new FileReader( "C:\\Users\\Mr.H\\Desktop\\employeeList.txt"));
            String data = br.readLine();
            while (data!=null)
            {
                String[] str =data.split(",");
                String Name = str[0];
                int Age = Integer.parseInt(str[1]);
                int Num = Integer.parseInt(str[2]);
                Employee employee=new Employee(Name,Age,Num);
                employeeList.add(employee);
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
    public static void savaData(LinkedList<Employee> employeeList)
    {
        PrintWriter printWriter = null;
        try{
                printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Mr.H\\Desktop\\employeeList.txt",false)));
                int employeeCount = employeeList.size();
                for (int i=0;i<employeeCount;i++)
                {
                    printWriter.println(employeeList.get(i).Name+","+ employeeList.get(i).Age+","+ employeeList.get(i).Num);

                }
                printWriter.flush();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            printWriter.close();
        }
    }

    public static void main(String[] args) {
        LinkedList<Employee> employeeList=new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Employee emp=new Employee("zhangsan"+i,i+20,100+i);
            employeeList.add(emp);
        }
        DataOperate dataOperate=new DataOperate();
        dataOperate.savaData(employeeList);
    }
}
