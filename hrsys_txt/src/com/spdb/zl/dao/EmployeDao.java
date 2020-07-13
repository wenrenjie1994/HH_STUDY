package com.spdb.zl.dao;

import com.spdb.zl.bean.Employe;

import java.io.*;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

public class EmployeDao {
    private String path = "employe.txt";

    /**
     * 通过追加的方式写入文件
     * @param emp
     */
    public void addEmploye(Employe emp){

        //文件的续写
        FileWriter fw = null;
        try {
            fw = new FileWriter(path,true);
            fw.write(emp.toString());
            //写入换行
            fw.write("\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入文件，写入文件将会覆盖原文件内容
     */
    public void saveEmploye(List<Employe> list){
        try {
            FileOutputStream outputStream  = new FileOutputStream(new File(path));
            for (Employe e : list) {
                outputStream.write(e.toString().getBytes());
                outputStream.write("\n".getBytes());
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employe> parseTxt(){
        LinkedList<Employe> list = new LinkedList<>();
        // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
        try {
            //读入TXT文件
            // 要读取以上路径的input。txt文件
            File filename = new File(path);
            // 建立一个输入流对象reader
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            // 建立一个对象，它把文件内容转成计算机能读懂的语言
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
                String[] attr= line.split(",");
                Employe emp = new Employe();
                emp.setName(attr[0]);
                emp.setAge(attr[1]);
                emp.setSex(attr[2]);
                emp.setUniversity(attr[3]);
                list.add(emp);
                // 一次读入一行数据
                line = br.readLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
