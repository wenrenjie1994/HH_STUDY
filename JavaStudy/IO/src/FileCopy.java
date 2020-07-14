import java.io.*;

/**
 * 文件的复制
 */
public class FileCopy {
    public static void main(String[] args) {
        //先建立两个file对象
        File file=new File("IO\\caoruitest.txt");
        File copy=new File("IO\\caoruitestCopy.txt");
        //创建输入流和输出流，一边读取，一边写入
        byte[] b=new byte[1024];

        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(copy);){
            int len=0;
            while((len=fis.read(b))!=-1){
                fos.write(b,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
