package LinkList;

import Bean.Student;

/**
 * @author：ljj0452@gmail.com
 * @time: 2020/7/4 22:14
 */

public class StudentNode {
    private Student data;
    private StudentNode next;
    public StudentNode(){}
    public StudentNode(Student data) {
        this.data = data;
    }
    public StudentNode(Student data, StudentNode next) {
        this.data = data;
        this.next = next;
    }


    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    public StudentNode getNext() {
        return next;
    }

    public void setNext(StudentNode next) {
        this.next = next;
    }
}
