package LoadAndSaveDate;

import com.sun.org.apache.regexp.internal.RE;
import model.Candidate;

import java.io.*;
import java.util.LinkedList;

public class DataOperate {
    public static void loadData(LinkedList<Candidate> canList){
        String filePath = "E:\\HH-study\\LOWHRSys02\\src\\LoadAndSaveDate\\data.txt";
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以用throw
        //读写文件时，不关闭文件会导致资源泄露
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件
        try(FileReader reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader)){
            String line;
            while ((line = br.readLine()) != null){
                String[] content = line.split(",");
                String name = content[0];
                int age = Integer.valueOf(content[1]);
                String gender = content[2];
                String phoneNum = content[3];
                Candidate candidate = new Candidate(name,age,gender,phoneNum);
                canList.add(candidate);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void saveData(LinkedList<Candidate> canList){
        String filePath = "E:\\HH-study\\LOWHRSys02\\src\\LoadAndSaveDate\\data.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));) {
            for (int i = 0; i < canList.size(); i++) {
                String content = canList.get(i).getName() + ","
                        + canList.get(i).getAge() + ","
                        + canList.get(i).getGender() + ","
                        + canList.get(i).getPhoneNumber();
                bw.write(content + "\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
