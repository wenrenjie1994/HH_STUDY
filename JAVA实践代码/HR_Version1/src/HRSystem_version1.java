import bean.Resume;
import bean.ResumeList;

import java.util.Scanner;

/**
 * @author 熊彩铃
 * @program HRSystem_version1
 * @description 招聘系统
 * @date 2020/7/2 16:20
 */
public class HRSystem_version1 {
    private ResumeList resumes = new ResumeList();
    private Scanner input = new Scanner(System.in);

    HRSystem_version1(){

        while(true){
            System.out.println("*****欢迎进入招聘系统版本一*****");
            System.out.println("添加简历信息请按 1");
            System.out.println("删除简历信息请按 2");

            System.out.println("修改简历信息请按 3");
            System.out.println("查找简历信息请按 4");
            System.out.println("退出系统请按 0");

            Integer enter = input.nextInt();

            if(enter == 1){
                addResume();
            }else if(enter == 2){
                deleteResume();
            }else if(enter == 3){
                modifyResume();
            }else if(enter == 4){
                queryResume();
            }else if(enter == 5){
                break;
            }else{
                System.out.println("输入有误，请重新选择");
            }
        }
    }
    /**
     * 添加简历
     * */
    private void addResume() {
        System.out.println("欢迎进入添加简历页面");
        System.out.println("请依次输入姓名、学校、身份证号码、性别、年龄");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String school = input.nextLine();
        String ID_number = input.nextLine();
        String gender = input.nextLine();
        Integer age = input.nextInt();

        Resume resume = new Resume(name,school,ID_number,gender,age);
        resumes.add(resume);
        System.out.println("添加简历成功");
        showResume();
    }

    /**
     * 删除简历
     * */
    private void deleteResume() {
        System.out.println("欢迎进入删除简历页面");
        System.out.println("请输入你要删除的名字");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        for(int i=0;i<resumes.size();i++){
            if(resumes.get(i).getName().equals(name)){
                resumes.remove(i);
                System.out.println("删除成功");
            }else if(i==resumes.size()-1){
                System.out.println("没有找到简历");
            }
        }
        showResume();
    }
    /**
     * 修改简历
     * */
    private void modifyResume() {
        System.out.println("欢迎进入修改简历页面");
        System.out.println("请出入需要修改的名字");
        Scanner input = new Scanner(System.in);
        String old_name = input.nextLine();
        System.out.println("请依次输入姓名、学校、身份证号码、性别、年龄");

        String new_name = input.nextLine();
        String new_school = input.nextLine();
        String new_ID_number = input.nextLine();
        String new_gender = input.nextLine();
        Integer new_age = input.nextInt();
        for(int i=0;i<resumes.size();i++){
            if(resumes.get(i).getName().equals(old_name)){
                resumes.get(i).setName(new_name);
                resumes.get(i).setSchool(new_school);
                resumes.get(i).setID_number(new_ID_number);
                resumes.get(i).setGender(new_gender);
                resumes.get(i).setAge(new_age);
                System.out.println("修改成功");
            }else if(i==resumes.size()-1){
                System.out.println("没有找到简历");
            }
        }
        showResume();
    }
    /**
     * 查找简历
     * */
    private void queryResume() {
        System.out.println("欢迎进入查询简历页面");
        System.out.println("请输入你要查询的名字");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        for(int i=0;i<resumes.size();i++){
            if (resumes.get(i).getName().equals(name)){
                System.out.println("查询到的简历信息为：");
                System.out.println(resumes.get(i).getName()+","+resumes.get(i).getSchool()+","
                        +resumes.get(i).getID_number()+","+resumes.get(i).getGender()+","
                        +resumes.get(i).getAge());
            }else if(i==resumes.size()-1){
                System.out.println("没有找到简历");
            }
        }
        showResume();
    }
    /**
     * 展示简历
     * */
    private void showResume() {
        System.out.println("简历信息************");
        for(int i=0;i<resumes.size();i++){
            System.out.println(resumes.get(i).getName()+","+resumes.get(i).getSchool()+","
                    +resumes.get(i).getID_number()+","+resumes.get(i).getGender()+","
                    +resumes.get(i).getAge());
            }
    }


    public static void main(String[] args){
        new HRSystem_version1();
    }
}
