package com.ram.utils;
import java.io.*;
import java.util.LinkedList;

// 基于文本的HR系统
public class DataOperate {
    // 载入应聘者信息
    public static void loadData(LinkedList<Resume> resumeList) {
        // 先将BufferedReader设置为空
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\goose\\Desktop\\hr.txt"));
            String data = br.readLine();
            while (data != null) {
                // 以逗号为分隔符，读取四个数据
                String[] str = data.split(",");
                String resumeName = str[0];
                String resumeAge = str[1];
                String resumeEducation = str[2];
                String resumeGender = str[3];

                // new个新对象
                Resume resume = new Resume(resumeName, resumeAge, resumeEducation, resumeGender);

                resumeList.add(resume);
                // 继续读取下一个数据
                data = br.readLine();
            }
            // 异常处理
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                // 谨记关闭数据流
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 保存应聘者
    public static void saveResume(LinkedList<Resume> resumeList) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\goose\\Desktop\\hr.txt", false)));
            int resumeCount = resumeList.size();
            // 将resumeList内容打印到txt文档中
            for (int i = 0; i < resumeCount; i++) {
                printWriter.println(resumeList.get(i).getName() + "," + resumeList.get(i).getAge() + "," + resumeList.get(i).getEducation() + "," + resumeList.get(i).getGender());
            }
            // flush和close的区别
            // flush将缓冲区的数据强制输出，用于清空缓冲区，
            // 若直接调用close()方法，则可能会丢失缓冲区的数据。所以通俗来讲它起到的是刷新的作用。
            printWriter.flush();
            // 异常处理
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }
}
