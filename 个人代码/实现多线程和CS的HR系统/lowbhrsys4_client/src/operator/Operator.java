package operator;

import main.HRS;
import model.ActionResult;
import net.Client;
import util.Parser;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author 杜波
 * @version 创建时间: 2020/7/20 16:54
 */
public class Operator {
    private static Client client = Client.getClient();

    public Operator() {

    }

    /**
     * 添加简历信息
     */
    public static void addResume() {
        System.out.println("欢迎来到添加简历界面");
        System.out.println("请依次输入需要添加的简历信息:姓名，身份证号，学校，简历状态( 0:已申请,1:简历通过,2:笔试通过," +
                "3:体检通过,4:背调通过,5:已签约,6:已入职)");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String id = input.nextLine();
        String school = input.nextLine();
        int process = Integer.parseInt(input.nextLine());
        String message="addResume"+"/n"+UUID.randomUUID().toString()+"/n"+name+"/n"+id+"/n"+school+"/n"+process;
        String returnMessage=client.sendMessageToSever(message);
        ActionResult actionResult=Parser.parserMessage(returnMessage);
        if(actionResult.getIsSuccess()){
            System.out.println("添加成功!");
        }else {
            System.out.println(actionResult.getFailReason());
        }
    }

    /**
     * 删除简历信息
     */
    public static void deleteResume() {
        System.out.println("欢迎来到删除简历界面");
        outloop:
        while (true) {

            System.out.println("-----欢迎进入HR系统-----");
            System.out.println("通过简历ID删除请按----1");
            System.out.println("通过简历姓名删除请按----2");
            System.out.println("通过简历身份证号删除请按----3");
            System.out.println("通过简历学校名称删除请按----4");
            System.out.println("通过简历状态删除请按----5");
            System.out.println("退出请按--------6");

            int choice = Integer.parseInt(HRS.scanner.nextLine());
            String message=null;
            String returnMessage=null;
            ActionResult actionResult=null;
            switch (choice) {
                case 1:
                    System.out.println("请输入简历id");
                    String resumeId = HRS.scanner.nextLine();
                    message="deleteResumeByResumeId"+"/n"+resumeId;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        System.out.println("删除成功!");
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 2:
                    System.out.println("请输入简历姓名");
                    String name = HRS.scanner.nextLine();
                    message="deleteResumeByName"+"/n"+name;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        System.out.println("删除成功!");
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 3:
                    System.out.println("请输入简历身份证号码");
                    String id = HRS.scanner.nextLine();
                    message="deleteResumeById"+"/n"+id;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        System.out.println("删除成功!");
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 4:
                    System.out.println("请输入简历学校名称");
                    String school = HRS.scanner.nextLine();
                    message="deleteResumeBySchool"+"/n"+school;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        System.out.println("删除成功!");
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 5:
                    System.out.println("请输入简历状态");
                    int process = Integer.parseInt(HRS.scanner.nextLine());
                    message="deleteResumeByProcess"+"/n"+process;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        System.out.println("删除成功!");
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 6:
                    break outloop;
                default:
                    System.out.println("输入错误，请重新输入!");
            }
        }
    }

    /**
     * 修改简历信息
     */
    public static void updateResume() {
        System.out.println("欢迎来到修改简历界面");
        outloop:
        while (true) {

            System.out.println("-----欢迎进入HR系统-----");
            System.out.println("修改指定简历姓名请按----1");
            System.out.println("修改指定简历身份证号码请按----2");
            System.out.println("修改指定简历学校请按----3");
            System.out.println("修改指定简历状态请按----4");
            System.out.println("修改指定简历的姓名、身份证号码、学校名称、状态请按----5");
            System.out.println("退出请按--------6");

            int choice = Integer.parseInt(HRS.scanner.nextLine());
            String resumeId=null;
            if(choice==1 || choice==2 || choice==3 || choice==4 || choice==5){
                System.out.println("请输入需要修改的简历id");
                resumeId = HRS.scanner.nextLine();
            }
            String message=null;
            String returnMessage=null;
            ActionResult actionResult=null;
            switch (choice) {
                case 1:
                    System.out.println("请输入修改后简历的姓名");
                    String name = HRS.scanner.nextLine();
                    message="updateResumeName"+"/n"+resumeId+"/n"+name;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        System.out.println("修改成功!");
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 2:
                    System.out.println("请输入修改后简历的身份证号码");
                    String id = HRS.scanner.nextLine();
                    message="updateResumeIdCard"+"/n"+resumeId+"/n"+id;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        System.out.println("修改成功!");
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 3:
                    System.out.println("请输入修改后简历的学校名称");
                    String school = HRS.scanner.nextLine();
                    message="updateResumeSchool"+"/n"+resumeId+"/n"+school;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        System.out.println("修改成功!");
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 4:
                    System.out.println("请输入修改后简历的状态(0:已申请,1:简历通过,2:笔试通过,3:体检通过,4:背调通过,5:已签约,6:已入职)");
                    int process = Integer.parseInt(HRS.scanner.nextLine());
                    message="updateResumeProcess"+"/n"+resumeId+"/n"+process;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        System.out.println("修改成功!");
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 5:
                    System.out.println("请输入修改后简历的姓名、身份证号码、学校名称、状态(0:已申请,1:简历通过,2:笔试通过,3:体检通过,4:背调通过,5:已签约,6:已入职)");
                    String name1 = HRS.scanner.nextLine();
                    String id1 = HRS.scanner.nextLine();
                    String school1 = HRS.scanner.nextLine();
                    int process1 = Integer.parseInt(HRS.scanner.nextLine());
                    message="updateResumeAll"+"/n"+resumeId+"/n"+name1+"/n"+id1+"/n"+school1+"/n"+process1;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        System.out.println("修改成功!");
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 6:
                    break outloop;
                default:
                    System.out.println("输入错误，请重新输入!");
            }
        }
    }

    /**
     * 查询简历信息
     */
    public static void queryResume() {
        System.out.println("欢迎来到查询简历界面");
        outloop:
        while (true) {

            System.out.println("-----欢迎进入HR系统-----");
            System.out.println("通过姓名查询请按----1");
            System.out.println("通过身份证号查询请按----2");
            System.out.println("通过学校名称查询请按----3");
            System.out.println("通过简历状态查询请按----4");
            System.out.println("查询所有请按----5");
            System.out.println("退出请按--------6");

            int choice = Integer.parseInt(HRS.scanner.nextLine());
            String message=null;
            String returnMessage=null;
            ActionResult actionResult=null;
            switch (choice) {
                case 1:
                    System.out.println("请输入姓名");
                    String name = HRS.scanner.nextLine();
                    message="queryResumeByName"+"/n"+name;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        Parser.printResume(actionResult.getResultData());
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 2:
                    System.out.println("请输入身份证号码");
                    String id = HRS.scanner.nextLine();
                    message="queryResumeById"+"/n"+id;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        Parser.printResume(actionResult.getResultData());
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 3:
                    System.out.println("请输入学校名称");
                    String school = HRS.scanner.nextLine();
                    message="queryResumeBySchool"+"/n"+school;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        Parser.printResume(actionResult.getResultData());
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 4:
                    System.out.println("请输入简历的状态( 0:已申请,1:简历通过,2:笔试通过,\" +\n" +
                            "                \"3:体检通过,4:背调通过,5:已签约,6:已入职)");
                    int process = Integer.parseInt(HRS.scanner.nextLine());
                    message="queryResumeByProcess"+"/n"+process;
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        Parser.printResume(actionResult.getResultData());
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 5:
                    message="queryResumeAll";
                    returnMessage=client.sendMessageToSever(message);
                    actionResult=Parser.parserMessage(returnMessage);
                    if(actionResult.getIsSuccess()){
                        Parser.printResume(actionResult.getResultData());
                    }else {
                        System.out.println(actionResult.getFailReason());
                    }
                    break;
                case 6:
                    break outloop;
                default:
                    System.out.println("输入错误，请重新输入!");
            }
        }
    }

    /**
     * 关闭socket连接
     */
    public static void closeClient() {
        client.sendMessageToSever("bye");
        client.closeClient();
    }
}
