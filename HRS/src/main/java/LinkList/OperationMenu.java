package LinkList;

import bean.Student;

/**
 * @author：ljj0452@gmail.com
 * @time: 2020/7/4 22:47
 */
public class OperationMenu {

    public static void main(String[] args) {
        Student student1 = new Student("100","Kevin1",22,"IOT",100);
        Student student2 = new Student("100","Kevin2",22,"IOT",100);
        Student student3 = new Student("100","Kevin3",22,"IOT",100);
        Student student4 = new Student("100","Kevin4",22,"IOT",100);
        Student student5 = new Student("100","Kevin5",22,"IOT",100);
        StudentSvc svc=new StudentSvc();
        svc.addStudent(student1);
        svc.addStudent(student2);
        svc.addStudent(student3);
        svc.addStudent(student4);
        svc.addStudent(student5);
        svc.showAllStudents();
        svc.delStudentByIndex(2);
        svc.showAllStudents();
    }
}
