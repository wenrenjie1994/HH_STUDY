package sys;

import bean.Resume;
import bean.ResumeList;
import work.Action;

import java.util.Scanner;

/**
 * @Author lee
 * @Date 2020/7/14 12:03 PM
 **/


public class HRS {

    public HRS() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 提示语句
            System.out.println("************欢迎来到HR系统************");
            System.out.println("填写简历请按----------1");
            System.out.println("删除简历请按----------2");
            System.out.println("修改简历请按----------3");
            System.out.println("查询简历请按----------4");
            System.out.println("退出系统请按----------5");

            int choice = sc.nextInt();
            if (choice == 1) {
                addResume();
            } else if (choice == 2) {
                deleteResume();
            } else if (choice == 3) {
                updateResume();
            } else if (choice == 4) {
                searchResume();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("输入有误，请重新输入！");
            }
        }
        System.out.println("您已经退出了HR系统");
    }

    // 添加简历
    void addResume() {
        System.out.println("欢迎来到简历添加界面");
        System.out.println("请依次输入姓名，身份证号和学校");

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String id = sc.nextLine();
        String school = sc.nextLine();
//        int process = sc.nextInt();
//        int deleteStatus = sc.nextInt();

        Resume resume = new Resume(name, id, school);

        Action a = new Action();
        int rs = a.addResume(resume);

        if (rs > 0) {
            System.out.println("您已成功添加简历！");
        } else {
            System.out.println("添加简历失败！");
        }
    }

    // 删除简历
    void deleteResume() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("************欢迎来到删除简历界面************");
            System.out.println("按姓名删除请按----------1");
            System.out.println("按身份证号删除请按-------2");
            System.out.println("按学校删除请按----------3");
            System.out.println("退出请按---------------4");

            int choice = sc.nextInt();
            if (choice == 1) {
                deleteResumeByName();
            } else if (choice == 2) {
                deleteResumeById();
            } else if (choice == 3) {
                deleteResumeBySchool();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("输入有误，请重新输入！");
            }
        }
    }

    void deleteResumeByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的简历的姓名");
        String resumeName = sc.nextLine();
        Resume resume = new Resume(resumeName, null, null);
        Action a = new Action();
        int rs = a.deleteResumeByName(resume);
        if (rs > 0) {
            System.out.println("删除简历成功");
        } else {
            System.out.println("没有找到该姓名，无法删除简历");
        }
    }

    void deleteResumeById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的简历的身份证号");
        String resumeId = sc.nextLine();
        Resume resume = new Resume(null, resumeId, null);
        Action a = new Action();
        int rs = a.deleteResumeById(resume);
        if (rs > 0) {
            System.out.println("删除简历成功");
        } else {
            System.out.println("没有找到该身份证号，无法删除简历");
        }
    }

    void deleteResumeBySchool() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的简历的学校");
        String resumeSchool = sc.nextLine();
        Resume resume = new Resume(null, null, resumeSchool);
        Action a = new Action();
        int rs = a.deleteResumeBySchool(resume);
        if (rs > 0) {
            System.out.println("删除简历成功");
        } else {
            System.out.println("没有找到该学校，无法删除简历");
        }
    }


    // 更新简历
    void updateResume() {
        //TODO
    }

    // 查询简历
    void searchResume() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("************欢迎来到查询简历界面************");
            System.out.println("按姓名查询请按----------1");
            System.out.println("按身份证号查询请按-------2");
            System.out.println("按学校查询请按----------3");
            System.out.println("退出请按---------------4");

            int choice = sc.nextInt();
            if (choice == 1) {
                searchResumeByName();
            } else if (choice == 2) {
                searchResumeById();
            } else if (choice == 3) {
                searchResumeBySchool();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("输入有误，请重新输入！");
            }
        }
    }

    void searchResumeByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要查询的简历的姓名");
        String resumeName = sc.nextLine();
        Resume resume = new Resume(resumeName, null, null);
        Action a = new Action();
        ResumeList rs = a.searchResumeByName(resume);
        int count = rs.size();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                System.out.println("姓名：" + rs.get(i).getName() + "  "
                        + "身份证号：" + rs.get(i).getId() + "  "
                        + "学校：" + rs.get(i).getSchool() + "  ");
            }
        } else {
            System.out.println("没有找到姓名为" + resumeName + "的简历");
        }
    }

    void searchResumeById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要查询的简历的身份证号");
        String resumeId = sc.nextLine();
        Resume resume = new Resume(null, resumeId, null);
        Action a = new Action();
        ResumeList rs = a.searchResumeById(resume);
        int count = rs.size();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                System.out.println("姓名：" + rs.get(i).getName() + "  "
                        + "身份证号：" + rs.get(i).getId() + "  "
                        + "学校：" + rs.get(i).getSchool() + "  ");
            }
        } else {
            System.out.println("没有找到身份证号为" + resumeId + "的简历");
        }
    }

    void searchResumeBySchool() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要查询的简历的学校");
        String resumeSchool = sc.nextLine();
        Resume resume = new Resume(null, null, resumeSchool);
        Action a = new Action();
        ResumeList rs = a.searchResumeBySchool(resume);
        int count = rs.size();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                System.out.println("姓名：" + rs.get(i).getName() + "  "
                        + "身份证号：" + rs.get(i).getId() + "  "
                        + "学校：" + rs.get(i).getSchool() + "  ");
            }
        } else {
            System.out.println("没有找到学校为" + resumeSchool + "的简历");
        }
    }


    public static void main(String[] args) {
        new HRS();
    }
}
