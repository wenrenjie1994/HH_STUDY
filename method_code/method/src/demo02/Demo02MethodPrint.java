package demo02;
//打印指定次数的Helloworld
public class Demo02MethodPrint {
    public static void main(String[] args) {
        printCount(5);

    }
    public static void printCount(int num){
        for(int i= 0;i<num;i++){
            System.out.println("Hello,world!"+i);
        }
    }
}
