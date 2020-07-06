package demo02;

public class Demo02Student {
    public static void main(String[] args) {
        Student stu =new Student();
        stu.setName("鹿晗");
        stu.setAge(20);
        stu.setMale(true);
        System.out.println("姓名是："+stu.getName());
        System.out.println("年龄是："+stu.getAge());
        System.out.println("是不是爷们："+stu.isMale());
    }
}
