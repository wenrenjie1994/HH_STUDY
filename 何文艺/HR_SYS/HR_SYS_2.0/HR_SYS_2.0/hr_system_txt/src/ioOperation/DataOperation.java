package ioOperation;

import model.Resume;
import java.io.*;
import java.util.LinkedList;

/**
 * @program: HR_SYS_2.0（基于txt文件）
 * @className: DataOperation
 * @description: IO流实现简历的加载和保存
 * @author: 何文艺
 * @creat: 2020/7/6 15:51
 **/
public class DataOperation {
    public static void loadData(LinkedList<Resume> resumeLinkedList) {
/*
    使用BufferedReader从文件中读取数据：
        1、首先创建FileReader对象
        2、将FileReader传递给BufferedReader
        3、采用BufferedReader的readLine()方法来读取文件内容
        4、对读取到的字符串进行处理
        5、最后一定要在finally语句中关闭BufferedReader
*/
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("E:/IdeaProjects/HR_SYS_2.0/resume.txt"));
            String resumeData = br.readLine();
            while (resumeData != null) {
                String[] str = resumeData.split(",");
                String name = str[0];
                String id = str[1];
                String school = str[2];
                Resume resume = new Resume(name, id, school);
                resumeLinkedList.add(resume);
                resumeData = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveData(LinkedList<Resume> resumeLinkedList) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("E:/IdeaProjects/HR_SYS_2.0/resume.txt")));
            for (int i = 0; i < resumeLinkedList.size(); i++) {
                printWriter.println(resumeLinkedList.get(i).name + "," + resumeLinkedList.get(i).id + "," + resumeLinkedList.get(i).school);
            }
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }
}
