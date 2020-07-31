package JavaDemo.Exception.Throws;

public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student();
        try {
            s.register(-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(s);
    }
}

class Student {
    private int id;

    public void register(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            //手动抛出异常
            throw new Exception("数据非法！！");
        }
    }
}
