package day02.demo;
public class Demo01 {
    //方法复习
    public static void main(String[] args) {

        printMethod();

    }
    public static  void printMethod(){

        for (int j = 0; j < 5; j++) {
            for(int i=1;i<=20;i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
