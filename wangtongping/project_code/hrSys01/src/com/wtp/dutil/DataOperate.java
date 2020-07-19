package com.wtp.dutil;

import com.wtp.model.Resume;

import java.io.*;
import java.nio.Buffer;
import java.util.LinkedList;

public class DataOperate {

    public static void loadData(LinkedList<Resume> resumeList){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./hrSys01/resumeList.txt"));
            String data = br.readLine();
            while(data!=null){
                String[] str = data.split(",");
                int id = Integer.parseInt(str[0]);
                String name = str[1];
                int age = Integer.parseInt(str[2]);
                int sex = Integer.parseInt(str[3]);
                String school = str[4];
                String major = str[5];
                String tel = str[6];
                String email = str[7];
                int status = Integer.parseInt(str[8]);

                Resume resume = new Resume(id, name, age, sex, school, major, tel, email, status);
                resumeList.add(resume);
                data = br.readLine();
            }
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveData(LinkedList<Resume> resumeList){
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./hrSys01/resumeList.txt", false)));
            int resumeCount = resumeList.size();
            for(int i=0; i<resumeCount; i++){
                printWriter.println(resumeList.get(i).getId() + "," + resumeList.get(i).getName() + "," +
                        resumeList.get(i).getAge() + "," + resumeList.get(i).getSex() + "," +
                        resumeList.get(i).getSchool() + "," + resumeList.get(i).getMajor() + "," +
                        resumeList.get(i).getTel() + "," + resumeList.get(i).getEmail() + "," +
                        resumeList.get(i).getStatus());
            }
            printWriter.flush();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        finally {
            printWriter.close();
        }
    }


}
