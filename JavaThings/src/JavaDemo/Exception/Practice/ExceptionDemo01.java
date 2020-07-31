package JavaDemo.Exception.Practice;

public class ExceptionDemo01 {
    static void methodA() {
        try {
            System.out.println("step into methodA");
            throw new RuntimeException("make exception");
        } finally {
            System.out.println("use methodA finally");
        }
    }

    static void methodB() {
        try {
            System.out.println("step into methodB");
            return;
        } finally {
            System.out.println("call methodB finally");
        }
    }

    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        methodB();
    }
}
