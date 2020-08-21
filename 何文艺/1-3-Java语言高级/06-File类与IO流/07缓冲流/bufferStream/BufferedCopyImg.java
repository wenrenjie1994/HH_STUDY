package bufferStream;

import java.io.*;

public class BufferedCopyImg {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(new File("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\bufferStream\\image1.jpg"));
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream(new File("E:\\IdeaProjects\\basic-code\\day0814-code\\src\\bufferStream\\image2.jpg"));
            bos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
