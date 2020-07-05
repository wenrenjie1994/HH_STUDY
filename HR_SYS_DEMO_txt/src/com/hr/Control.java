package com.hr;

import java.util.Scanner;

public class Control {
    public Control() {
        System.out.println("输入 1 添加简历\n输入 2 删除简历\n输入 3 查询简历\n输入 4 修改学生信息\n输入 5 退出\n输入 ？ 查询指令");
        Scanner userInput = new Scanner(System.in);
        String opCode = userInput.next();
        HumanResourceService hr = HumanResourceService.getInstance();
        while(!(opCode.charAt(0) == OpType.EXIT.getValue())){
            if(opCode.charAt(0) == OpType.ADD.getValue()){
                System.out.println("当前操作为：添加简历");
                String stdName, stdId, stdSchool;
                System.out.println("请输入简历姓名");
                stdName = userInput.next();
                System.out.println("请输入简历编号");
                stdId = userInput.next();
                System.out.println("请输入所属学校");
                stdSchool = userInput.next();
                hr.addStudent(new Resume(stdName, stdId, stdSchool));
            }else if(opCode.charAt(0) == OpType.DELETE.getValue()) {
                System.out.println("当前操作为：删除简历");
                System.out.println("请输入简历姓名");
                hr.deleteStudent(userInput.next());
            }else if(opCode.charAt(0) == OpType.QUERY.getValue()) {
                System.out.println("当前操作为：查询简历");
                System.out.println("是否列出所有简历信息？ y/n");
                if(userInput.next().equals("n")){
                    System.out.println("请输入简历姓名");
                    hr.queryStudent(userInput.next());
                }else{
                    hr.queryAllResume();
                }
            }else if(opCode.charAt(0) == OpType.MODIFY.getValue()) {
                System.out.println("当前操作为：修改简历");
                String oldName, newName, newId, newSchool;
                System.out.println("请输入简历姓名");
                oldName = userInput.next();
                System.out.println("请输入修改后的简历姓名");
                newName = userInput.next();
                System.out.println("请输入修改后的简历编号");
                newId = userInput.next();
                System.out.println("请输入修改后的所属学校");
                newSchool = userInput.next();
                hr.modifyStudent(oldName, newName, newId, newSchool);
            }else if(opCode.charAt(0) == OpType.HELP.getValue()) {
                System.out.println("输入 1 添加简历\n输入 2 删除简历\n输入 3 查询简历\n输入 4 修改简历信息\n输入 5 退出\n输入 ？ 查询指令");
            }else {
                System.out.println("无效的指令");
            }
                System.out.println("请输入下一步操作指令");
                opCode = userInput.next();
        }
        hr.storeResume();
        System.out.println("再见");
    }
    public static void main(String[] args){
        new Control();
    }
}
