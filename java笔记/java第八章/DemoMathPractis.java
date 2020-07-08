package basic.method.demo1.day4;
//计算在-10。8到5.9之间，绝对值大于6或者小于2.1的整数有多少个？
public class DemoMathPractis {
    public static void main(String[] args) {
    double min = -10.8;
    double max = 5.9;
    int count = 0;

    for (int i = (int)min; i<max; i++){
        int abs = Math.abs(i);
        if (abs>6||abs<2.1){
            System.out.println(i);
            count++;
        }
    }
        System.out.println("一共有整数："+count+"个");
    }
}
