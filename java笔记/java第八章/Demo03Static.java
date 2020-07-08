package basic.method.demo1.day4;

public class Demo03Static {
    public static void main(String[] args) {
        Student one = new Student("刘",18);
        one.room = "101教室";
        Student two = new Student("王",19);
        System.out.println("姓名："+one.getName()+"年龄"+one.getAge()+"教室："+one.room+"学号为："+one.getId());
        System.out.println("姓名："+two.getName()+"年龄"+two.getAge()+"教室："+two.room+"学号为："+two.getId());
    }
}
