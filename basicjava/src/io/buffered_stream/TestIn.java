package io.buffered_stream;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//找到一个大于100k的文件，按照100k为单位，拆分成多个子文件，并且以编号作为文件名结束。
//        比如文件 eclipse.exe，大小是309k。
//        拆分之后，成为
//        eclipse.exe-0
//        eclipse.exe-1
//        eclipse.exe-2
//        eclipse.exe-3
//把上述拆分出来的文件，合并成一个原文件。
//
//        以是否能正常运行，验证合并是否正确

public class TestIn {
    //拆分文件
    public void fileSplit (File file_in) {
        try(FileInputStream fis = new FileInputStream(file_in)){
            byte[] part = new byte[102400];
            long len = file_in.length();
            for (int i = 0; len >= 0; i ++){
                if (len < 102400){
                    part = new byte[(int) len];
                }
                fis.read(part);
                File file_out = new File("./src/io/byte_stream/test.pdf-"+i);
                FileOutputStream fos = new FileOutputStream(file_out);
                fos.write(part);
                System.out.println("输出子文件：" + file_out + " 文件大小为：" + file_out.length() + "字节");
                len -= 102400;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    //合并文件
    public void fileMerge() {
        File file_merge = new File("./src/io/byte_stream/merge_test.pdf");
        try(FileOutputStream fos = new FileOutputStream(file_merge)) {
            byte[] all = new byte[102400];
            for (int i = 0;;i++){
                File f = new File("./src/io/byte_stream/test.pdf-"+i);
                if(!f.exists()) break;

                FileInputStream fis = new FileInputStream(f);
                if(f.length() < 102400) all = new byte[(int) f.length()];
                while(fis.read(all) != -1) {
                    fos.write(all);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
