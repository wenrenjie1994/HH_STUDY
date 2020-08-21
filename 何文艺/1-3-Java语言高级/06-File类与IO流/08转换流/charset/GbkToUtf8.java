package charset;

import java.io.*;

public class GbkToUtf8 {
    public static void main(String[] args) {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //从gbk文件中读取gbk编码的数据
            isr = new InputStreamReader(new FileInputStream("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\charset\\gbk.txt"),"GBK");
            //将gbk编码的数据转换成utf-8编码并写入到utf8.txt文件
            osw = new OutputStreamWriter(new FileOutputStream("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\charset\\utf8.txt"),"UTF-8");
            int len = 0;
            while ((len = isr.read()) != -1) {
                osw.write(len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null) {
                    osw.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
