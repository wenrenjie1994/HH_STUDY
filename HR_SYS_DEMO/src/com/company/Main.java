package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("输入 1 添加学生\n输入 2 删除学生\n输入 3 查询学生\n输入 4 修改学生信息\n输入 5 退出\n");
        Scanner userInput = new Scanner(System.in);
        String opCode = userInput.next();
        while(!(Integer.valueOf(opCode) == OpType.EXIT.getValue())){
            if(Integer.valueOf(opCode) == OpType.ADD.getValue()){
                System.out.println("hh");
            }
            opCode = userInput.next();
        }
        System.out.println("再见");
    }
}
