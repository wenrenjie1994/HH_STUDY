package demo03;

public class Demo03Student {
    public static void main(String[] args) {
        Student stu = new Student();
        Student stu2 =new Student("赵丽颖",20);
        System.out.println(stu2.getName());
        System.out.println(stu2.getAge());
    }
}
