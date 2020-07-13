package dataSolve;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import bean.Resume;

public class DataSolve
{
    public static List<Resume> loadData()
    {
        List<Resume> resumes = new LinkedList<>();
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("C:/Users/xc li/Desktop/resumes.txt"));
            String data = br.readLine();
            while(data!=null)
            {
                String[] str = data.split(",");
                String name = str[0];
                String id = str[1];
                String school= str[2];
                int process = Integer.parseInt(str[3]);
                int deleteStatus = Integer.parseInt(str[4]);
                Resume resume = new Resume(name, id, school, process, deleteStatus);
                resumes.add(resume);
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
        return resumes;
    }

    public static void saveData(List<Resume> resumes)
    {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:/Users/xc li/Desktop/resumes.txt",false)));//¸²¸ÇÐ´Èë
            int resumesCount = resumes.size();
            for(int i=0;i<resumesCount;i++)
            {
                printWriter.println(resumes.get(i).getName()+","+resumes.get(i).getId()+","+resumes.get(i).getSchool()+","+resumes.get(i).getProcess()+","+resumes.get(i).getDeleteStatus());
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