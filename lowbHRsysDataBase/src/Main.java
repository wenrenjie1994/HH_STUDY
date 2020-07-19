import dao.ResumeDao;
import entity.Resume;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("************欢迎来到LowB招聘管理系统************");
            System.out.println("增加简历请按----------1");
            System.out.println("删除简历请按----------2");
            System.out.println("修改简历请按----------3");
            System.out.println("查询简历请按----------4");
            System.out.println("退出请按--------------5");
            int choice =Integer.parseInt(input.next());
            if(choice==1) {
                System.out.println("欢迎来到添加简历界面");
                Scanner add = new Scanner(System.in);
                System.out.println("请依次输入需要添加应聘者的姓名，学校，应聘岗位");
                String studentName =add.nextLine();
                String school =add.nextLine();
                String position =add.nextLine();
                Resume resume = new Resume(studentName,school,position);
                ResumeDao.addResume(resume);
                System.out.println("您已成功添加简历");
                ResumeDao.searchAll();
            }
            else if(choice==2) {
                deleteResume();

            }
            else if(choice==3) {
                updateResume();
            }
            else if(choice==4) {
                searchResume();
            }
            else if(choice==5) {
                break;
            }
            else {
                System.out.println("输入错误，请确认后从新输入");
            }
        }
        System.out.println("您已退出LowB招聘管理系统");
    }

     static void  deleteResume(){
        HashMap<String,String> map = new HashMap<>();
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("************欢迎来到删除简历界面************");
            System.out.println("按照简历编号删除----------1");
            System.out.println("按照学生姓名删除----------2");
            System.out.println("退出删除界面----------3");
            int choice = input.nextInt();
            if (choice == 1) {
                Scanner sc = new Scanner(System.in);
                System.out.println("******请输入要删除的简历编号******");
                String resumeNo = sc.nextLine();
                map.put("id", resumeNo);
                int line = ResumeDao.deleteByCondition(map);
                if (line == 1) {
                    System.out.println("删除该简历成功");
                } else {
                    System.out.println("没有查找到该简历,删除失败");
                }
                map.clear();
            } else if (choice == 2) {
                Scanner sc = new Scanner(System.in);
                System.out.println("******请输入要删除的简历学生姓名******");
                String name = sc.nextLine();
                map.put("name", name);
                int line = ResumeDao.deleteByCondition(map);
                if (line == 1) {
                    System.out.println("删除该简历成功");
                } else {
                    System.out.println("没有查找到该简历,删除失败");
                }
                map.clear();
            } else{
                break;
            }
        }
        ResumeDao.searchAll();
    }
    static void updateResume(){
        HashMap<String,String> map = new HashMap<>();
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("************欢迎来到修改简历界面************");
            System.out.println("按照简历编号修改----------1");
            System.out.println("按照学生姓名修改----------2");
            System.out.println("退出修改界面----------3");
            int choice = input.nextInt();
            if (choice == 1) {
                Scanner sc = new Scanner(System.in);
                System.out.println("******请输入要修改的简历编号,新学生姓名，新学校，新意向岗位******");
                String resumeNo = sc.nextLine();
                String newName = sc.nextLine();
                String newSchool = sc.nextLine();
                String newPosition = sc.nextLine();
                map.put("id", resumeNo);
                Resume resume = new Resume(newName,newSchool,newPosition);
                int line = ResumeDao.updateByCondition(map,resume);
                if (line == 1) {
                    System.out.println("修改该简历成功");
                } else {
                    System.out.println("没有查找到该简历,修改失败");
                }
                map.clear();
            } else if (choice == 2) {
                Scanner sc = new Scanner(System.in);
                System.out.println("******请输入要修改的原学生姓名,新学生姓名，新学校，新意向岗位******\"");
                String name = sc.nextLine();
                String newName = sc.nextLine();
                String newSchool = sc.nextLine();
                String newPosition = sc.nextLine();
                map.put("name", name);
                Resume resume = new Resume(newName,newSchool,newPosition);
                int line = ResumeDao.updateByCondition(map,resume);
                if (line == 1) {
                    System.out.println("修改该简历成功");
                } else {
                    System.out.println("没有查找到该简历,修改失败");
                }
                map.clear();
            } else{
                break;
            }
        }
        ResumeDao.searchAll();
    }
    static void searchResume(){
        HashMap<String,String> map = new HashMap<>();
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("************欢迎来到查看简历界面************");
            System.out.println("按照简历编号查找----------1");
            System.out.println("按照学生姓名查找----------2");
            System.out.println("按照投递岗位查找----------3");
            System.out.println("查看所有简历----------4");
            System.out.println("退出查看界面----------5");
            int choice = input.nextInt();
            if (choice == 1) {
                Scanner sc = new Scanner(System.in);
                System.out.println("******请输入要查看的简历编号******");
                String resumeNo = sc.nextLine();
                map.put("id", resumeNo);
               LinkedList<Resume>list = ResumeDao.searchByCondition(map);
                if (list.size()==1) {
                    System.out.println("简历编号:"+list.get(0).getId()+" 学生姓名："+list.get(0).getName()+" 来自 "+list.get(0).getSchool()+" 应聘职位是： "+list.get(0).getPosition());
                } else {
                    System.out.println("没有查找到该简历");
                }
                map.clear();
            } else if (choice == 2) {
                Scanner sc = new Scanner(System.in);
                System.out.println("******请输入要查看的简历学生姓名******");
                String name = sc.nextLine();
                map.put("name", name);
                LinkedList<Resume>list = ResumeDao.searchByCondition(map);
                if (list.size() == 1) {
                    System.out.println("简历编号:"+list.get(0).getId()+" 学生姓名："+list.get(0).getName()+" 来自 "+list.get(0).getSchool()+" 应聘职位是： "+list.get(0).getPosition());
                } else {
                    System.out.println("没有查找到该简历,删除失败");
                }
                map.clear();
            } else if (choice == 3){
                Scanner sc = new Scanner(System.in);
                System.out.println("******请输入要查看的岗位******");
                String position = sc.nextLine();
                map.put("position", position);
                LinkedList<Resume>list = ResumeDao.searchByCondition(map);
                if (list.size() == 0) {
                    System.out.println("该岗位下没有查找到简历");
                } else {
                    System.out.println("该招聘岗位下共有"+list.size()+"份简历");
                    for(int i=1;i<=list.size();i++) {
                        System.out.println("第"+i+"份简历"+"---------"+"简历编号:"+list.get(i-1).getId()+" 学生姓名："+list.get(i-1).getName()+" 来自 "+list.get(i-1).getSchool()+" 应聘职位是： "+list.get(i-1).getPosition());
                    }
                }
                map.clear();
            }else if (choice == 4){
                ResumeDao.searchAll();
            }else{
                break;
            }
        }
        ResumeDao.searchAll();
    }
}
