package cn.itcast;

public class demo1 {
    public static void main(String[] args) {
        printMethod();
    }
    public static void printMethod(){
        for (int i = 0; i < 5; i++) {
            for (int i1 = 0; i1 < 20; i1++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
