package util;

import model.Resume;

import java.io.*;
import java.util.ArrayList;

/**
 * 文本数据操作方法类
 * @author 杜波
 * @version 创建时间: 2020/7/9 13:40
 */
public class DataOperate {
    /**
     * 加载文本数据方法
     * @param resumeList
     */
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

    /**
     * 保存数据到文本
     * @param resumeList
     */
    public static void saveData(ArrayList<Resume> resumeList)
    {
        PrintWriter printWriter = null;
        try {
            String path=System.getProperty("user.dir")+File.separator+"textFile"+File.separator+"resumelist.txt";
            //覆盖写入
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path,false)));
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
