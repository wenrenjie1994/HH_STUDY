/*
 @version text 版本
 @Author wvv
 @data 2020/7/8
 */
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import entity.Student;
import service.StudentService;

public class Main
{
    static int num=0;  //文件和内存中最大简历编号
    public static void main(String[] args) {

        LinkedList<Student> studentList = new LinkedList<Student>();
        Scanner input = new Scanner(System.in);
        loadData(studentList);
        if(!studentList.isEmpty()){
            num = studentList.getLast().getStuNo();
        }
        while(true)
        {
            System.out.println("************欢迎来到LowB招聘管理系统************");
            System.out.println("增加学生请按----------1");
            System.out.println("删除学生请按----------2");
            System.out.println("修改学生请按----------3");
            System.out.println("查询学生请按----------4");
            System.out.println("退出请按--------------5");
            int choice =Integer.parseInt(input.next());
            if(choice==1)
            {
                StudentService.addStudent(studentList,++num);
            }
            else if(choice==2)
            {
                num=StudentService.deleteStudent(studentList);

            }
            else if(choice==3)
            {
                StudentService.updatestudent(studentList);
            }
            else if(choice==4)
            {
                StudentService.showResume(studentList);
            }
            else if(choice==5)
            {
                saveData(studentList);
                break;
            }
            else {
                System.out.println("输入错误，请确认后从新输入");
            }
        }
        System.out.println("您已退出LowB招聘管理系统");
    }

    public static void loadData(LinkedList<Student> studentList)
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("C://Users/Administrator/Desktop/studentlist.txt"));
            String data = br.readLine();
            while(data!=null)
            {
                String[] str = data.split(",");
                int stuNo =Integer.parseInt(str[0]);
                String name =str[1];
                String school = str[2];
                String position = str[3];
                Student student = new Student(stuNo,name,school,position);
                studentList.add(student);
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

    public static void saveData(LinkedList<Student> studentList)
    {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C://Users/Administrator/Desktop/studentlist.txt",false)));//覆盖写入
            for(int i=0;i<studentList.size();i++)
            {
                printWriter.println(studentList.get(i).getStuNo()+","+studentList.get(i).getName()+","+studentList.get(i).getSchool()+","+studentList.get(i).getPosition());
            }
            printWriter.flush(); //清空缓冲区
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