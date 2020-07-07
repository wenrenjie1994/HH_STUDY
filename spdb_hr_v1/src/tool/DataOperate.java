package tool;

import bean.Resume;

import java.io.*;
import java.util.LinkedList;

public class DataOperate {
    public static LinkedList<Resume> loadData() {
        LinkedList<Resume> resumeList = new LinkedList<>();
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("E:/project/HH_STUDY/spdb_hr_v1/doucument/resumelist.txt"));
            String data = br.readLine();
            while(data!=null)
            {
                String[] tmp = data.split(",");
                Resume resume = new Resume(tmp[0],tmp[1],tmp[2],Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
                resumeList.add(resume);
                data = br.readLine();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resumeList;
    }

    public static void saveData(LinkedList<Resume> resumeList)
    {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("E:/project/HH_STUDY/spdb_hr_v1/doucument/resumelist.txt",false)));
            for(int i=0;i<resumeList.size();i++)
            {
                printWriter.println(resumeList.get(i).getId()+","+resumeList.get(i).getName()+","+resumeList.get(i).getSchool()+","+resumeList.get(i).getProcess()+","+resumeList.get(i).getDeleteStatus());
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
