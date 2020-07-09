package loadandsaveData;
import java.io.*;
import java.util.LinkedList;
import model.Resume;
//数据操作类：主要负责数据的存储和读取操作
public class DataOperate {
    public static void loadData(LinkedList<Resume> resumeList,String filepath)
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(filepath));
            String data = br.readLine();
            while(data!=null)
            {
                String[] str = data.split(",");
                String resumeName =str[0];
                String resumeId =str[1];
                String resumeSchool=str[2];
                Resume resume = new Resume(resumeName, resumeId,resumeSchool);
                resume.setProcess(Integer.parseInt(str[3]));
                resume.setDeleteStatus(Integer.parseInt(str[4]));
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

    public static void saveData(LinkedList<Resume> resumeList,String filepath)
    {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filepath)));//覆盖写入
            int resumeCount = resumeList.size();
            for(int i=0;i<resumeCount;i++)
            {
                printWriter.println(
                        resumeList.get(i).getName()+","
                        +resumeList.get(i).getId()+","
                        +resumeList.get(i).getSchool()+","
                        +resumeList.get(i).getProcess()+","
                        +resumeList.get(i).getDeleteStatus());
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
