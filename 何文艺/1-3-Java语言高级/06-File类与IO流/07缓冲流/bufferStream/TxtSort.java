package bufferStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class TxtSort {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\bufferStream\\a.txt")));
            bw = new BufferedWriter(new FileWriter(new File("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\bufferStream\\b.txt")));
            HashMap<Integer, String> map = new HashMap<>();
            //1.从a.txt读取数据并存储到Map集合中
            String s = null;
            while ((s = br.readLine()) != null) {
                map.put((int) s.charAt(0), s);
                //Map集合会自动排序
            }
            //2.将排好序的文本写入到b.txt文件中
            for (Integer key : map.keySet()) {
                bw.write(map.get(key));
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
