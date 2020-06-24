package method;

import java.io.File;
import java.io.FileFilter;

/**
 * @Author: A wei
 * @Date: 2020/6/23 17:36
 * @Last Modified by:
 * @last Modified date:
 * @Description: java8之前采用匿名类的方式进行参数传递
 */
public class BeforeJava8 {
    public static void main(String[] args) {

        File[] hiddenFilesJava7 = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
    }
}
