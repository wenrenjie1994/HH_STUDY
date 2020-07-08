package Main;
import com.ram.utils.Candidate;
import com.ram.utils.CandidateOperate;
import java.util.LinkedList;
import java.util.Scanner;

public class Hrsys {
    public static void main(String[] args) {
        // LinkedList<类型> list = new LinkedList<>() 创建新链表型列表

        LinkedList<Candidate> candidateList = new LinkedList<Candidate>();
        // LinkedList和ArrayList的区别：
        // （1）ArrayList是Array(动态数组)的数据结构
        // （2）LinkedList是Link(链表)的数据结构。
        // （3）随机访问（get和set）时，ArrayList优于LinkedList；新增和删除操作，LinedList比较占优势。”

        // 数据输入流
        Scanner input = new Scanner(System.in);
        int doCount = 1;
        // 循环判断
        do{
            System.out.println("########## 欢迎来到人事管理系统 Beta1.0(基于内存) ##########");
            System.out.println(">>>> [增加应聘者请按----------1]：");
            System.out.println(">>>> [删除应聘者请按----------2]：");
            System.out.println(">>>> [修改应聘者请按----------3]：");
            System.out.println(">>>> [查询应聘者请按----------4]：");
            System.out.println(">>>> [遍历应聘者请按----------5]：");
            System.out.println(">>>> [退出请按--------------0]：");

            // switch语句进行选项判断
            int choice = input.nextInt();
            switch(choice) {
                // 增
                case 1:
                    CandidateOperate.addCandidate(candidateList);
                    break;

                // 删
                case 2:
                    CandidateOperate.deleteCandidate(candidateList);
                    break;

                // 改
                case 3:
                    CandidateOperate.updateCandidate(candidateList);
                    break;

                // 查
                case 4:
                    CandidateOperate.searchCandidate(candidateList);
                    break;
                // 遍历
                case 5:
                    CandidateOperate.showCandidate(candidateList);
                    break;

                default:
                    System.out.println("×××× 输入格式错误，请确认后从新输入！");
                    break;

                case 0:
                    System.out.println("(*^_^*) 您已退出简历管理系统");
                    doCount = 0;
            }

        }while(doCount==1);
    }
}

