package com.lihang.util;

import com.lihang.pojo.Resume;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/7/5
 */
public class FileUtils {
    private static FileWriter fw = null;
    private static PrintWriter pw = null;
    private static FileReader fr = null;
    private static BufferedReader br = null;
    private static BufferedWriter bw = null;


    /**
     * @param object
     * @param path
     * @throws IOException
     * @throws IllegalAccessException
     * @function object insert into file
     */
    public static void objinsertToFile(Object object, String path) throws IOException, IllegalAccessException {
        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("file is not exist,I will create a new file");
            File parentFile = new File(file.getParent());
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fw = new FileWriter(file, true);
        pw = new PrintWriter(fw, true);
        pw.println(objToString(object));
        fw.close();
        pw.close();

    }

    /**
     * @param t
     * @param name
     * @param path
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IOException
     * @function get Object By name
     */
    public static <T> T getObjectByName(Class<T> t, String name, String path) throws IllegalAccessException, InstantiationException, IOException {
        T instance = t.newInstance();
        Class clazz = instance.getClass();
        Field[] fields = clazz.getDeclaredFields();
        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("文件名不存在");
            return null;
        }
        fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.contains(name)) {
                String[] values = line.split("#");
                for (int i = 0; i < values.length; i++) {
                    Type type = fields[i].getType();
                    if (type == Integer.class) {
                        fields[i].setAccessible(true);
                        fields[i].set(instance, Integer.parseInt(values[i]));
                    } else {
                        fields[i].setAccessible(true);
                        fields[i].set(instance, values[i]);
                    }
                }
            }
        }
        fr.close();
        br.close();
        return instance;
    }

    /**
     * delete
     * @param name
     * @param path
     * @throws IOException
     */
    public static void deleteByname(String name, String path) throws IOException {
        if (!check(path)) {
            return;
        }
        File file = new File(path);
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        String line = null;
        List<String> lines = new ArrayList<>();
        while ((line=br.readLine())!=null){
            if (line.contains(name)){
                continue;
            }
            lines.add(line);
        }

        fr.close();
        br.close();
        clearFile(path);
        fw = new FileWriter(file,true);
        pw = new PrintWriter(fw,true);
        for (String newline :lines){
            pw.println(newline);
        }
    }

    /**
     * update
     * @param name
     * @param newLine
     * @param path
     * @throws IOException
     */
    public static void updateOneLine(String name,String newLine, String path) throws IOException {
        if (!check(path)){
            return;
        }
        deleteByname(name,path);
        File file = new File(path);
        fw = new FileWriter(file,true);
        pw = new PrintWriter(fw,true);
        pw.println(newLine);
        fw.close();
        pw.close();
    }
    public static void clearFile(String path) throws IOException {

        File file = new File(path);
        fw = new FileWriter(file);
        fw.write("");
        fw.flush();
        fw.close();
    }
    /**
     * @param obj
     * @return
     * @throws IllegalAccessException
     * @function 对象转字符串
     */
    public static String objToString(Object obj) throws IllegalAccessException {
        Class clazz = obj.getClass();
        Field[] filelds = clazz.getDeclaredFields();
        StringBuffer newLine = new StringBuffer();
        for (Field field : filelds) {
            field.setAccessible(true);//禁止访问控制检查
            newLine.append(field.get(obj).toString() + "#");
        }
        return newLine.toString();
    }

    public static Boolean check(String path) {
        File file = new File(path);
        if (file.isDirectory() || !file.exists()) {
            System.out.println("文件不存在");
            return false;
        }
        return true;
    }

}
