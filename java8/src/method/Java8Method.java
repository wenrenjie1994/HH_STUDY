package method;

import java.io.File;

/**
 * @Author: A wei
 * @Date: 2020/6/23 17:49
 * @Last Modified by:
 * @last Modified date:
 * @Description: java8的方法引用
 */
public class Java8Method {

    public static void main(String[] args) {

        File[] hiddenFilesJava8 = new File(".").listFiles(File::isHidden);
    }
}
