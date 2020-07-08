package util;

import model.Resume;

import java.io.*;
import java.util.ArrayList;

public class DataOperate {
    public static void loadData(ArrayList<Resume> resumeList)
    {
        BufferedReader br = null;
        try
        {
            String path=System.getProperty("user.dir")+File.separator+"textFile"+File.separator+"resumelist.txt";
            br = new BufferedReader(new FileReader(path));
            String data = br.readLine();
            while(data!=null)
            {
                String[] str = data.split(",");
                String name =str[0];
                String id =str[1];
                String school=str[2];
                int process=Integer.parseInt(str[3]);
                Resume resume = new Resume(name,id,school,process);
                resumeList.add(resume);
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

    public static void saveData(ArrayList<Resume> resumeList)
    {
        PrintWriter printWriter = null;
        try {
            String path=System.getProperty("user.dir")+File.separator+"textFile"+File.separator+"resumelist.txt";
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path,false)));//覆盖写入
            int resumeCount = resumeList.size();
            for(int i=0;i<resumeCount;i++)
            {
                printWriter.println(resumeList.get(i).getName()+","+resumeList.get(i).getId()+","+resumeList.get(i).getSchool()
                        +","+resumeList.get(i).getProcess());
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
