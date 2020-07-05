package LinkList;

import bean.Student;

import java.util.Scanner;

/**
 * @author：ljj0452@gmail.com
 * @time: 2020/7/4 22:13
 */
public class StudentSvc {
    private static StudentNode head = new StudentNode();

    // 添加学生
    public void addStudent(Student student) {
        // 初始化插入的student对象
        StudentNode newSNode = new StudentNode(student);
        // 暂存头节点
        StudentNode temp = head;
        // 找到尾节点
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newSNode);
    }

    // 遍历链表
    public void showAllStudents() {
        StudentNode temp = head;
        int index = 1;
        while (temp != null) {
            if (temp.getData() != null) {
                System.out.println((index++) + ": " + temp.getData().toString());
            }
            temp = temp.getNext();
        }
    }

    // 索引删除学生
    public void delStudentByIndex(int index) {
        if (index < 1) {
            System.out.println("需要输入正确的索引值！");
            return;
        }
        StudentNode temp = head;
        int nowPos = 0;
        while (temp.getNext() != null) {
            if (nowPos == index - 1) {
                StudentNode delNode = temp.getNext();
                temp.setNext(delNode.getNext());
                return;
            }
            nowPos++;
            temp = temp.getNext();
        }
    }

    // 索引修改学生
    public void updateStudentByIndex(int index, Student student) {
        if (index < 1) {
            System.out.println("需要输入正确的索引值！");
            return;
        }
        Scanner sc = new Scanner(System.in);
        StudentNode temp = head;
        int nowPos = 0;
        while (temp.getNext() != null) {
            if (nowPos == index - 1) {
                temp.getNext().setData(student);
                return;
            }
            nowPos++;
            temp = temp.getNext();
        }
    }
}
