package filefilter;

import java.io.File;

public class javaFilter {
    public static void main(String[] args) {
        javaFilter(new File("E:\\myStudy\\HH_STUDY\\何文艺\\1-3-Java语言高级\\06-File类与IO流\\02递归\\abc"));
    }

    public static void javaFilter(File file) {
        File[] files = file.listFiles(new FileFilterImpl());
        for (File f : files) {
            if (f.isDirectory()) {
                javaFilter(f);
            } else {
                System.out.println(f);
            }
        }
    }
}
