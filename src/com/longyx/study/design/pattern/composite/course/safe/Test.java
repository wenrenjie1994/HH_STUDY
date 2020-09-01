package com.spdb.study.design.pattern.composite.course.safe;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 11:32
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("==========安全模式==========");

        File qq = new File("QQ.exe");
        File weChat = new File("微信.exe");

        Folder office = new Folder("办公软件",2);

        File word = new File("Word.exe");
        File ppt = new File("PowerPoint.exe");
        File excel = new File("Excel.exe");

        office.add(word);
        office.add(ppt);
        office.add(excel);

        Folder root = new Folder("F盘：",1);
        root.add(qq);
        root.add(weChat);
        root.add(office);

        root.show();

        System.out.println("======================List=======================");
        root.list();
    }
}
