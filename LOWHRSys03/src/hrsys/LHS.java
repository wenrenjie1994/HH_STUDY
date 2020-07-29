package hrsys;

import bean.Candidate;
import bean.CandidateList;
import work.Action;

import java.util.Scanner;

public class LHS {
    public static void LHS() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printHRSys();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addCandidate();
                    break;
                case 2:
                    deleteCandidate();
                    break;
                case 3:
                    updateCandidate();
                    break;
                case 4:
                    searchCandidate();
                    break;
                case 5:
                    searchCandidateAll();
                    break;
                case 0:
                    System.out.println("已退出简单招聘系统...");
                    return;
                default:
                    System.out.println("输入格式错误，请重新输入！");
                    break;
            }
        }
    }


    public static void printHRSys() {
        System.out.println("============欢迎来到简单招聘系统2.0(基于JDBC)==============");
        System.out.println("增加应聘者请输入-----1");
        System.out.println("删除应聘者请输入-----2");
        System.out.println("更新应聘者请输入-----3");
        System.out.println("查询应聘者请输入-----4");
        System.out.println("打印应聘者列表请输入-----5");
        System.out.println("退出招聘系统-----0");
    }

    public static void addCandidate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****************欢迎来到新增页面****************");
        System.out.println("请依次输入新增应聘者的姓名 年龄 性别 电话");

        String name = scanner.next();
        int age = scanner.nextInt();
        String gender = scanner.next();
        String phoneNum = scanner.next();
        Candidate candidate = new Candidate(name, age, gender, phoneNum);

        Action action = new Action();
        int line = action.addCandidate(candidate);
        if (line >= 1) {
            System.out.println("新增成功！");
        } else {
            System.out.println("新增失败！");
        }

    }

    public static void deleteCandidate() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("****************欢迎进入删除页面******************");
            System.out.println("按名字删除请输入1");
            System.out.println("按电话号码删除请输入2");
            System.out.println("退出删除页面请输入0");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    deleteCandidateByName();
                    break;
                case 2:
                    deleteCandidateByPhoneNumber();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("输入格式错误，请重新输入！");
                    break;
            }
        }
    }

    public static void deleteCandidateByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要删除的应聘者姓名");
        String name = scanner.next();
        Action action = new Action();
        int line = action.deleteCandidateByName(name);
        if (line > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    public static void deleteCandidateByPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要删除的应聘者电话号码");
        String phoneNumber = scanner.next();
        Action action = new Action();
        int line = action.deleteCandidateByPhoneNumber(phoneNumber);
        if (line > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    public static void updateCandidate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****************欢迎进入更新页面******************");
        boolean flag = true;
        while (flag) {
            System.out.println("更新姓名请输入1");
            System.out.println("更新年龄请输入2");
            System.out.println("更新性别请输入3");
            System.out.println("更新电话号码请输入4");
            System.out.println("退出更新页面请输入0");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    updateCandidateByName();
                    break;
                case 2:
                    updateCandidateByAge();
                    break;
                case 3:
                    updateCandidateByGender();
                    break;
                case 4:
                    updateCandidateByPhoneNumber();
                    break;
                case 0:
                    System.out.println("已退出更新页面");
                    return;
                default:
                    System.out.println("输入格式错误，请重新输入！");
                    break;
            }
        }

    }

    public static void updateCandidateByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要修改的应聘者姓名");
        String oldName = scanner.nextLine();
        System.out.println("请输入新的姓名");
        String name = scanner.next();
        Action action = new Action();
        int line = action.updateCandidateByName(oldName, name);
        if (line > 0)
            System.out.println("修改姓名成功！");
        else
            System.out.println("修改姓名失败！");
    }

    public static void updateCandidateByAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要修改的应聘者姓名");
        String name = scanner.nextLine();
        System.out.println("请输入新的年龄");
        int age = scanner.nextInt();
        Action action = new Action();
        int line = action.updateCandidateByAge(name, age);
        if (line > 0)
            System.out.println("修改年龄成功！");
        else
            System.out.println("修改年龄失败！");
    }

    public static void updateCandidateByGender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要修改的应聘者姓名");
        String name = scanner.nextLine();
        System.out.println("请输入新的性别");
        String gender = scanner.next();
        Action action = new Action();
        int line = action.updateCandidateByGender(name, gender);
        if (line > 0)
            System.out.println("修改性别成功！");
        else
            System.out.println("修改性别失败！");
    }

    public static void updateCandidateByPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要修改的应聘者姓名");
        String name = scanner.nextLine();
        System.out.println("请输入新的电话号码");
        String phoneNumber = scanner.next();
        Action action = new Action();
        int line = action.updateCandidateByPhoneNumber(name, phoneNumber);
        if (line > 0)
            System.out.println("修改电话号码成功！");
        else
            System.out.println("修改电话号码失败！");
    }

    public static void searchCandidate() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("****************欢迎进入查询页面******************");
            System.out.println("按名字查询请输入1");
            System.out.println("按年龄查询请输入2");
            System.out.println("按性别查询请输入3");
            System.out.println("按电话查询请输入4");
            System.out.println("退出查询页面请输入5");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    searchCandidateByName();
                    break;
                case 2:
                    searchCandidateByAge();
                    break;
                case 3:
                    searchCandidateByGender();
                    break;
                case 4:
                    searchCandidateByPhoneNumber();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
        System.out.println("已退出查询页面....");
    }

    public static void searchCandidateByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的姓名");
        String name = scanner.next();
        Action action = new Action();
        CandidateList candidates = action.searchCandidateByName(name);
        int count = candidates.size();
        if (count == 0) {
            System.out.println("未查询到姓名为" + name + "的应聘者信息！");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("第" + (i + 1) + "个应聘者：\t姓名："
                    + candidates.get(i).getName() + "\t年龄："
                    + candidates.get(i).getAge() + "\t性别："
                    + candidates.get(i).getGender() + "\t电话："
                    + candidates.get(i).getPhoneNumber());
        }
    }

    public static void searchCandidateByAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的年龄");
        int age = scanner.nextInt();
        Action action = new Action();
        CandidateList candidates = action.searchCandidateByAge(age);
        int size = candidates.size();
        if (size == 0) {
            System.out.println("未查询到年龄为" + age + "的应聘者信息！");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println("第" + (i + 1) + "个应聘者：\t姓名："
                    + candidates.get(i).getName() + "\t年龄："
                    + candidates.get(i).getAge() + "\t性别："
                    + candidates.get(i).getGender() + "\t电话："
                    + candidates.get(i).getPhoneNumber());
        }
    }

    public static void searchCandidateByGender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的性别");
        String Gender = scanner.next();
        Action action = new Action();
        CandidateList candidates = action.searchCandidateByGender(Gender);
        int count = candidates.size();
        if (count == 0) {
            System.out.println("未查询到性别为" + Gender + "的应聘者信息！");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("第" + (i + 1) + "个应聘者：\t姓名："
                    + candidates.get(i).getName() + "\t年龄："
                    + candidates.get(i).getAge() + "\t性别："
                    + candidates.get(i).getGender() + "\t电话："
                    + candidates.get(i).getPhoneNumber());
        }
    }

    public static void searchCandidateByPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的电话号码");
        String phoneNumber = scanner.next();
        Action action = new Action();
        CandidateList candidates = action.searchCandidateByPhoneNumber(phoneNumber);
        int count = candidates.size();
        if (count == 0) {
            System.out.println("未查询到电话号码为" + phoneNumber + "的应聘者信息！");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("第" + (i + 1) + "个应聘者：\t姓名："
                    + candidates.get(i).getName() + "\t年龄："
                    + candidates.get(i).getAge() + "\t性别："
                    + candidates.get(i).getGender() + "\t电话："
                    + candidates.get(i).getPhoneNumber());
        }
    }

    public static void searchCandidateAll() {
        Action action = new Action();
        CandidateList candidates = action.searchCandidateAll();
        int size = candidates.size();
        if (size == 0) {
            System.out.println("当前无应聘者信息！");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println("第" + (i + 1) + "个应聘者：\t姓名："
                    + candidates.get(i).getName() + "\t年龄："
                    + candidates.get(i).getAge() + "\t性别："
                    + candidates.get(i).getGender() + "\t电话："
                    + candidates.get(i).getPhoneNumber());
        }
    }

    public static void main(String[] args) {
        LHS();
    }
}
