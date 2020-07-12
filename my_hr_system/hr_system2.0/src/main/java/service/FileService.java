package service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import model.Resume;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.util.LinkedList;

/**
 * @Author: chenlei
 * @Date: 2020/7/12 18:17
 */
public class FileService {
    private static String path;
    public FileService() {
        path = this.getFilePath();
    }
    /**
     * 通过文件选择器获取文件路径，限制文件只能为json格式的文件
     * @return
     */
    public String getFilePath() {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".json");
            }

            @Override
            public String getDescription() {
                return "获取json结尾的文件";
            }
        };
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(fileChooser);
        String filePath = System.getProperty("user.dir") + "\\test.json";
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            //这个就是你选择的文件夹的路径
            filePath = fileChooser.getSelectedFile().getAbsolutePath();
        }
        return filePath;
    }

    /**
     * 从文件夹中读取数据并返回简历列表
     * @return
     * @throws FileNotFoundException
     */
    public LinkedList<Resume> readFile() {
        File file = new File(path);
        if(file.exists()) {
            LinkedList<JSONObject> jsonList = new LinkedList<JSONObject>();
            try {
                InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                BufferedReader bf = new BufferedReader(inputReader);
                // 按行读取字符串并转为json
                String str;
                while ((str = bf.readLine()) != null) {
                    jsonList.add(JSON.parseObject(str));
                }
                bf.close();
                inputReader.close();
            }catch (Exception e) {
                System.out.println("数据格式错误");
                return new LinkedList<Resume>();
            }
            LinkedList<Resume> resumeList = new LinkedList<>();
            for(JSONObject object : jsonList) {
                if(object!= null) {
                    Resume resume = new Resume(object.get("name").toString(),(Integer) object.get("year"),object.get("job").toString());
                    resumeList.add(resume);
                }
            }
            return resumeList;
        }else{
            System.out.println("文件不存在");
            return null;
        }
    }

    /**
     * 向文件中写数据
     * @param resumeList
     */
    public void writeFile(LinkedList<Resume> resumeList) {
        File file = new File(path);
        if(file.exists()) {
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
                BufferedWriter writer = new BufferedWriter(outputStreamWriter);
                for(Resume resume : resumeList) {
                    writer.write(JSONObject.toJSONString(resume) + "\r\n");
                }
                writer.close();
                outputStreamWriter.close();
            }catch (Exception e) {
                System.out.println("文件写入失败");
                return;
            }
            System.out.println("文件写入成功");
        }else {
            System.out.println("文件不存在");
        }
    }
}
