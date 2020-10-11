package com.longyx.study.design.pattern.visitor.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * JDK中访问者模式的应用FileVisitor
 * @author Mr.Longyx
 * @date 2020年07月12日 23:13
 */
public class FileVisitorTest {
    public static void main(String[] args) {
        try {
            /**
             * 使用FileVisitor对目录进行遍历
             * @author Mr.Longyx
             * @date 2020/7/12 23:15
             */
            Files.walkFileTree(Paths.get("E:","github/HH_STUDY/src/com/longyx/study/design/pattern/visitor"), new SimpleFileVisitor<Path>(){
                /**
                 * 访问子目录前触发该方法
                 * @author Mr.Longyx
                 * @date 2020/7/12 23:21
                 */
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    System.out.println("正在访问"+dir+"目录");
                    return FileVisitResult.CONTINUE;
                }

                /**
                 * 访问文件时触发该方法
                 * @author Mr.Longyx
                 * @date 2020/7/12 23:24
                 */
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
                    System.out.println("正在访问"+file+"文件");
                    if (file.endsWith("FileVisitorTest.java")) {
                        System.out.println("=======FileVisitorTest.java,文件内容========");
                        List<String> list = Files.readAllLines(file);
                        /**
                         * 打印出文件内容
                         * @author Mr.Longyx
                         * @date 2020/7/12 23:27
                         * @param file
                         * @param attributes
                         * @return java.nio.file.FileVisitResult
                         */
                        System.out.println(list);
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }

                /**
                 * 访问失败时触发该方法
                 * @author Mr.Longyx
                 * @date 2020/7/12 23:29
                 */
                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exception) throws IOException {
                    return super.visitFileFailed(file, exception);
                }

                /**
                 * 访问目录后触发该方法
                 * @author Mr.Longyx
                 * @date 2020/7/12 23:31
                 */
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException ex) throws IOException {
                    return super.postVisitDirectory(dir, ex);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
