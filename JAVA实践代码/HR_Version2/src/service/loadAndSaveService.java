package service;

import model.Resume;

import java.io.*;
import java.util.LinkedList;

/**
 * @author 熊彩铃
 * @program HR_Version2
 * @description 数据操作，包括从文件中读取数据和存数据至文件中
 * @date 2020/7/6 0:19
 */
public class loadAndSaveService {

    public static void save(LinkedList<Resume> resumeLinkedList) {
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("E://Code//resumeData.txt",false)));
            for(int i=0;i<resumeLinkedList.size();i++){
                Resume resume = resumeLinkedList.get(i);
                pw.println(resume.getName()+","+resume.getID_number()+","+resume.getSchool()+","+resume.getAge());
            }
            pw.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            pw.close();
        }

    }

    public LinkedList<Resume> load() {
        BufferedReader br = null;
        LinkedList<Resume> resumeLinkedList = new LinkedList<Resume>();
        try{
            br = new BufferedReader(new FileReader("E://Code//resumeData.txt"));
            String resumeData = br.readLine();
            while(resumeData!=null){
                String[] resume = resumeData.split(",");
                String name = resume[0];
                String ID_name = resume[1];
                String school = resume[2];
                Integer age = Integer.parseInt(resume[3]);
                resumeLinkedList.add(new Resume(name,ID_name,school,age));
                resumeData = br.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                br.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return resumeLinkedList;
    }
}
