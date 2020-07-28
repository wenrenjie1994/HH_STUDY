package basic.method.demo1.day14;

public class Demo01Thread {
    public static void main(String[] args) {
        Mythread mt = new Mythread();
        mt.start();
    /*    for (int i = 0; i < 10; i++) {
            System.out.println("main"+i);
        }*/
//        mt.getName();
//        new Mythread().getName();
        new Mythread().start();
    }
}
