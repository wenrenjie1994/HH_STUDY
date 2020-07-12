package com.caorui.data;

import com.caorui.bean.Applicant;

import java.io.*;
import java.util.LinkedList;

public class DataControl {
    private static LinkedList<Applicant> Aplist;
    private static File file;

    public DataControl() {
        if (Aplist == null) {
            Aplist = new LinkedList<Applicant>();
            file = new File("d:/1/pufa_HR/message.txt");
            if (!file.exists()) {
                //为防止文件夹1和pufa_HR不存在，要先创建txt文件的所有父文件夹
                file.getParentFile().mkdirs();
                //如果没有上一个操作，如果文件夹不存在，会报错。
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static LinkedList getApList() throws FileNotFoundException {
        //先从文件中读取信息，装入list中，再把这个list返回
        file = new File("d:/1/pufa_HR/message.txt");
        if (Aplist == null) {
            Aplist = new LinkedList<Applicant>();
        }else{
            Aplist.clear();//先将list清0
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            String message = br.readLine();
            while (message != null) {
                String[] s = message.split(",");
                String name = s[0];
                String id = s[1];
                String school = s[2];
                int process = Integer.parseInt(s[3]);
                int deleteStatus = Integer.parseInt(s[4]);

                Applicant ap = new Applicant(name, id);
                ap.setSchool(school);
                ap.setProcess(process);
                ap.setDeleteStatus(deleteStatus);
                Aplist.add(ap);
                //至此一个ap对象建立完成，将其添加到list中

            message = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Aplist;//文件中的信息全部存储到list中了
    }

    public static void Write(LinkedList aplist)  {
        //先把文件txt删除，再新建一个空白的文件，再把新的list写入txt文件
        int Apcount = aplist.size();
        file = new File("d:/1/pufa_HR/message.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //往文件里写
        try (PrintWriter pw=new PrintWriter(file)){
            for (int i = 0; i < Apcount; i++) {
                pw.write(Aplist.get(i).getName() + "," +
                        Aplist.get(i).getId() + "," +
                        Aplist.get(i).getSchool() + "," +
                        Aplist.get(i).getProcess() + "," +
                        Aplist.get(i).getDeleteStatus()+"\n"
                );
                pw.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
