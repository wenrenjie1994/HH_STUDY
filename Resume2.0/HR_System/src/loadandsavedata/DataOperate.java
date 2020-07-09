package loadandsavedata;
import java.io.*;
import java.util.LinkedList;
import module.*;

public class DataOperate {
    private LinkedList<Resume> resumeList =new LinkedList<Resume>();

    public void setResumeList(LinkedList<Resume> resumeList) {
        this.resumeList = resumeList;
    }

    public LinkedList<Resume> getResumeList() {
        return resumeList;
    }

    public void loadData(){
        BufferedReader br= null;
        try
        {
            br =new BufferedReader(new FileReader("C:/Users/linziyi/Desktop/resumelist.txt"));
            String data = br.readLine();
            while(data!=null){
                String[] str = data.split(",");
                String name =str[0];
                String id =str[1];
                String school =str[2];
                int process = Integer.parseInt(str[3]);
                int deleteStatus= Integer.parseInt(str[4]);
                Resume resume = new Resume(name,id,school,process,deleteStatus);
                resumeList.add(resume);
                data = br.readLine();
            }
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
        finally {
            try{
                br.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public void saveData(){
        PrintWriter printWriter= null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("/Users/linziyi/Desktop/resumelist.txt",false)));//覆盖写入
            int count = resumeList.size();
            for(int i=0;i<count;i++)
            {
                printWriter.println(resumeList.get(i).getName()+","+resumeList.get(i).getId()+","+resumeList.get(i).getSchool()+","+resumeList.get(i).getProcess()+","+resumeList.get(i).getDeleteStatus());
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
