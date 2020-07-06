package sys;

import dataoperation.DataOperation;
import model.Resume;
import service.ResumeService;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class HRS {
    public static void main(String[] args) {

        LinkedList<Resume> resumeList = new LinkedList<Resume>();
        Scanner input = new Scanner(System.in);

        String txtPath = null;
        try {
            File directory = new File("");  // 当前文件夹
            Path path = Paths.get(directory.getCanonicalPath(), "src", "datasource", "resumelist.txt");
            txtPath = path.toString();

            File filename = new File(txtPath);
            if (!filename.exists()) {
                boolean flag = filename.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        DataOperation.loadData(resumeList, txtPath);  // 加载已保存的数据

        while (true) {

            System.out.println();
            System.out.println("-----欢迎进入HR简历管理系统-----");
            System.out.println("添加学生简历请按----1");
            System.out.println("删除学生简历请按----2");
            System.out.println("修改学生简历信息请按----3");
            System.out.println("显示学生简历信息请按----4");
            System.out.println("退出系统请按--------5");

            int choice = input.nextInt();
            switch (choice) {

                case 1:
                    ResumeService.addResume(resumeList);
                    break;

                case 2:
                    ResumeService.delResume(resumeList);
                    break;

                case 3:
                    ResumeService.updateResume(resumeList);
                    break;

                case 4:
                    ResumeService.showResume(resumeList);
                    break;

                case 5:
                    DataOperation.saveData(resumeList, txtPath);  // 保存数据
                    input.close();//流啊 连接啊 这些东西 用完记得关；要么记得还（那么什么地方是需要还的，什么地方是关的）；
                    System.out.println("您已经退出HR简历管理系统");
                    return;

                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }
}
