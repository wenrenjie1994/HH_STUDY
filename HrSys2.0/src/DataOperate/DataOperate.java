package DataOperate;

import bean.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataOperate {


    public static void loadData(ArrayList<Resume> resumes){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\DELL\\Desktop\\ResumeList.txt"));
            String data = bufferedReader.readLine();
            while (data!=null){
                String[] str = data.split(":");
                String name =str[0];
                int age = Integer.parseInt(str[1]);
                String idCard =str[2];
                String school =str[3];
                int processState = Integer.parseInt(str[4]);
                int deteleStatus = Integer.parseInt(str[5]);
                Resume resume= new Resume(name,age,idCard,school,processState,deteleStatus);
                resumes.add(resume);
                data = bufferedReader.readLine();
            }


        }
        catch (IOException exception){
            exception.printStackTrace();

        }
        finally {
            try {
                bufferedReader.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void saveData(ArrayList<Resume> resumes) {
        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\DELL\\Desktop\\ResumeList.txt",false)));
            for(int i=0;i<resumes.size();i++){
                printWriter.println(resumes.get(i).getName()+":"+resumes.get(i).getAge()+":"+resumes.get(i).getIdCard()+":"+resumes.get(i).getSchool()+":"
                        +resumes.get(i).getProcessState()+":"+resumes.get(i).getDeleteStatus());
            }
            printWriter.flush();

        }
        catch (IOException e){
            e.printStackTrace();

        }
        finally {
            printWriter.close();

        }

    }
}
