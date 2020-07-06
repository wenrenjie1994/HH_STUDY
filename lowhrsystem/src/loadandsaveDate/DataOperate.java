package loadandsaveDate;

import model.Employee;


import java.io.*;
import java.util.LinkedList;

public class DataOperate {
    public static void loadData(LinkedList<Employee> employeeList)
    {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("E:/pufa_study/employeelist.txt"));
            String data = br.readLine();
            while(data != null)
            {
                String[] str = data.split(",");
                String employeeJobNumber =  str[0];
                String employeeName = str[1];
                int emploeeAge = Integer.parseInt(str[2]);
                String employeeGender = str[3];
                String employeePhone = str[4];
                Employee employee = new Employee(employeeJobNumber,employeeName,emploeeAge,employeeGender,employeePhone);
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
            try
            {
                br.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
    public static void saveData(LinkedList<Employee> employeeList)
    {
        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(
                    "E:/pufa_study/employeelist.txt",false)));
            int count = employeeList.size();
            for(int i = 0;i<count;i++)
            {
                printWriter.println(employeeList.get(i).employeeJobNumber+","+employeeList.get(i).employeeName
                        +","+employeeList.get(i).employeeAge+","+employeeList.get(i).employeeGender+","+employeeList.get(i).employeePhone);
            }
            printWriter.flush();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();;
        }
        finally
        {
            printWriter.close();
        }
    }
}
