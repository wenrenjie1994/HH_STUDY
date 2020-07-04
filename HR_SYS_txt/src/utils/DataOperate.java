package utils;

import bean.Resume;
import bean.ResumeList;

import java.io.*;


public class DataOperate {

    final static String filepath = "E:\\JAVA\\HH_STUDY\\HR_SYS_txt\\resumelist.txt";

    public static void loadData(ResumeList list){
        //String filepath = "E:\\JAVA\\HH_STUDY\\HR_SYS_txt\\resumelist.txt";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = bufferedReader.readLine();
            while (s!=null){
                String[] split = s.split(",");
                String name = split[0];
                String id = split[1];
                String school = split[2];
                Resume newResume = new Resume(name,id,school);
                list.add(newResume);
                s = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void saveData(ResumeList list){
        //String filepath = "E:\\JAVA\\HH_STUDY\\HR_SYS_txt\\resumelist.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filepath,false);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);

            int resumeSize = list.size();
            for (int i=0;i<resumeSize;i++) {
                printWriter.println(list.get(i).getName()+","+list.get(i).getId()+","+list.get(i).getSchool());
            }
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
