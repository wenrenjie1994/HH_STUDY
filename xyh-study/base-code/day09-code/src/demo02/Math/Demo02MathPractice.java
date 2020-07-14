package demo02.Math;
/*
题目
计算-10.8到5.9之间，绝对值大于6或者小于2.1的整数
*/
public class Demo02MathPractice {
    public static void main(String[] args) {
        //向上取整
       int a=(int)Math.ceil(-10.8);
       //int 可强制舍弃所有小数
       int b=(int)5.9;
       int num=0;
        for (int i =a ; i <=b ; i++) {
            if(Math.abs(i)>6||Math.abs(i)<2.1){
                System.out.println(i);
                num++;
            }

        }
        System.out.println("满足要求的一共有："+num+"个");
    }
}
