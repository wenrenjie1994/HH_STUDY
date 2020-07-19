package demo2;

public class Demo02Student {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("赵丽颖",18);
        System.out.println(student2.getName()+student2.getAge());
    }
}
