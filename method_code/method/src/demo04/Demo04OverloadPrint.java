package demo04;
//byte short int long double float boolean
// boolean
public class Demo04OverloadPrint {
    public static void main(String[] args) {
        mPrint(100);
        mPrint("Hello");

    }
    public static void mPrint(byte num){
        System.out.println(num);
    }
    public static void mPrint(short num){
        System.out.println(num);
    }
    public static void mPrint(int num){
        System.out.println(num);
    }
    public static void mPrint(long num){
        System.out.println(num);
    }public static void mPrint(char c){
        System.out.println(c);
    }public static void mPrint(double num){
        System.out.println(num);
    }public static void mPrint(float num){
        System.out.println(num);
    }public static void mPrint(String str){
        System.out.println(str);
    }
    public static void mPrint(boolean b){
        System.out.println(b);
    }
}
