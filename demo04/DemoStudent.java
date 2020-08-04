package fu.day04.demo04;

public class DemoStudent {
    public static void main(String[] args) {
        Student stu=new Student();
        stu.setName("哈哈");
        stu.setAge(20);
        stu.setMale(true);

        System.out.println("姓名："+stu.getName());
        System.out.println("年龄："+stu.getAge());
        System.out.println("是否男性："+stu.isMale());
    }
}

