package dateOperator;

import model.JobHunter;

import java.util.LinkedList;
import java.util.Scanner;

public class JobHunterOperator {

    //添加求职者
    public static void addJobHunter(LinkedList<JobHunter> jobHuntersList){
        System.out.println("=====欢迎进入添加求职者界面====");

        Scanner sc = new Scanner(System.in);
        System.out.println("请依次输入需要添加的求职者姓名，性别，专业，学校，年龄");
        String name = sc.nextLine();
        //String age = sc.nextLine();
        String gender = sc.nextLine();
        String major = sc.nextLine();
        String school = sc.nextLine();
        int age = sc.nextInt();
        //get/SET
        //JobHunter jobHunter = new JobHunter(name, age, gender, major, school);
        JobHunter jobHunter = new JobHunter(name, gender, major, school, age);
        //System.out.println(gender);

        jobHuntersList.add(jobHunter);

        System.out.println("您已成功添加该求职者");
        showJobHunter(jobHuntersList);
    }

    //删除求职者
    public static void deleteJobHunter(LinkedList<JobHunter> jobHuntersList){
        System.out.println("=====欢迎进入删除求职者界面====");

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入删除的求职者姓名和专业");
        String name = sc.nextLine();
        String major = sc.nextLine();

        //get/SET
        if (!jobHuntersList.isEmpty()) {
            for (int i = 0; i < jobHuntersList.size(); i++) {

                if (jobHuntersList.get(i).getName().equals(name) && (jobHuntersList.get(i).getMajor().equals(major))){
                    jobHuntersList.remove(jobHuntersList.get(i));
                    System.out.println("您已成功删除该求职者");
                    showJobHunter(jobHuntersList);
                    break;
                }else if(i == jobHuntersList.size() - 1){
                    System.out.println("未找到该求职者");
                }
            }
        }else{
            System.out.println("系统为空，未找到该求职者！");
        }

    }

    //修改求职者
    public static void updateJobHunter(LinkedList<JobHunter> jobHuntersList) {
        System.out.println("=====欢迎进入修改求职者界面====");
        System.out.println("请输入需要进行修改的求职者姓名");
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        if (!jobHuntersList.isEmpty()) {
            for (int i = 0; i < jobHuntersList.size(); i++) {
                if (jobHuntersList.get(i).getName().equals(name)) {
                    System.out.println("请依次输入新的姓名，性别，专业，学校，年龄");
                    String newName = sc.nextLine();
                    //String newAge = sc.nextLine() ;
                    String newGender = sc.nextLine();
                    String newMajor = sc.nextLine();
                    String newSchool = sc.nextLine();
                    int newAge = sc.nextInt();
                    //JobHunter jobHunter = new JobHunter(newName, newAge, newGender, newMajor, newSchool);
                    JobHunter jobHunter = new JobHunter(newName,  newGender, newMajor, newSchool,newAge);
                    jobHuntersList.set(i, jobHunter);
                    System.out.println("您已修改成功");
                    showJobHunter(jobHuntersList);
                } else if (i == jobHuntersList.size() - 1 || jobHuntersList.size() == 0) {
                    System.out.println("没有查到求职者");
                }
            }
        } else {
            System.out.println("系统为空，没有查找到该求职者");
        }
    }

    //查询求职者
    public static void searchJobHunter(LinkedList<JobHunter> jobHuntersList) {
        System.out.println("=====欢迎进入查询求职者界面====");
        System.out.println("请输入需要进行查询的求职者姓名");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        for (int i = 0; i < jobHuntersList.size(); i++) {
            if (jobHuntersList.get(i).getName().equals(name)){
                System.out.println(jobHuntersList.get(i).getName() + "  " + "年龄:" + jobHuntersList.get(i).getAge()
                        + "  " + "性别:" + jobHuntersList.get(i).getGender() + "  " + "专业:" +
                        jobHuntersList.get(i).getMajor() + "  " + "学校:" + jobHuntersList.get(i).getSchool()
                        + "  " + "位于第" + (i+1) + "个位置");
                break;
            }else if (i == jobHuntersList.size() - 1){
                System.out.println("没有找到该求职者，请重新输入！");
            }
        }
    }

    //展示求职者
    public static void showJobHunter(LinkedList<JobHunter> jobHuntersList) {
        System.out.println("是否需要打印所有求职者，是请输入Y，不用打印则输入任意");
        Scanner sc = new Scanner(System.in);

        String printJobHunters = sc.nextLine();
        if (printJobHunters.equals("Y")) {
            System.out.println("HR系统共有" + jobHuntersList.size() + "个求职者");
            for (int i = 0; i < jobHuntersList.size(); i++) {

                System.out.println("第"+(i+1)+"个求职者" + "----" + jobHuntersList.get(i).getName());
            }
        }
    }
}
