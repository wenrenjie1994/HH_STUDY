package com.company;

import java.util.Scanner;

public class Control {
    public Control() {
        System.out.println("输入 1 添加学生\n输入 2 删除学生\n输入 3 查询学生\n输入 4 修改学生信息\n输入 5 退出\n输入 ？ 查询指令");
        Scanner userInput = new Scanner(System.in);
        String opCode = userInput.next();
        HumanResourceService hr = new HumanResourceService();
        while(!(opCode.charAt(0) == OpType.EXIT.getValue())){
            if(opCode.charAt(0) == OpType.ADD.getValue()){
                String stdName, stdId;
                System.out.println("请输入学生姓名");
                stdName = userInput.next();
                System.out.println("请输入学生编号");
                stdId = userInput.next();
                hr.addStudent(new Student(stdName, stdId));
            }else if(opCode.charAt(0) == OpType.DELETE.getValue()) {
                System.out.println("请输入学生姓名");
                hr.deleteStudent(userInput.next());
            }else if(opCode.charAt(0) == OpType.QUERY.getValue()) {
                System.out.println("请输入学生姓名");
                hr.queryStudent(userInput.next());
            }else if(opCode.charAt(0) == OpType.MODIFY.getValue()) {

            }else if(opCode.charAt(0) == OpType.HELP.getValue()) {
                System.out.println("输入 1 添加学生\n输入 2 删除学生\n输入 3 查询学生\n输入 4 修改学生信息\n输入 5 退出\n输入 ？ 查询指令");
            }else {
                System.out.println("无效的指令");
            }
                System.out.println("请输入下一步操作指令");
                opCode = userInput.next();
        }
        System.out.println("再见");
    }
}
