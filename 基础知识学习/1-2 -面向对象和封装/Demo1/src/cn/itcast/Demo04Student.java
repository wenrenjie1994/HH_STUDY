package cn.itcast;

public class Demo04Student {
    public static void main(String[] args){
        Student s = new Student();
        s.setName("鹿晗");
        s.setAge(22);
        s.setMale(true);
        System.out.println("姓名："+s.getName());
        System.out.println("年龄："+s.getAge());
        System.out.println("是不是爷们："+s.isMale());

    }
}
