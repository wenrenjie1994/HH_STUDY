package day04.demo;
import javax.lang.model.element.NestingKind;
import java.util.Scanner;
/*
常用API：
1.Scanner类的功能：可以实现键盘输入数据到程序中。
引用类型的一般使用步骤：
1.导包
import 包路径.类名称
注：
1）如果需要使用的目标类和当前类位于同一个包下，则可以省略导包语句。
2）只有java.lang包下的内容不需要导包，其它包都需要import语句。
2.创建
3.使用
*/
public class Demo1 {
    public static void main(String[] args) {
        //String在java.lang中，无需导包
        String str="123";
        //从键盘进行输入
        Scanner sc=new Scanner(System.in);
        //用int类型接收
        int input=sc.nextInt();
        //用String类型接收
        String str1=sc.next();
        System.out.println("输入的数字是："+input);
        System.out.println("输入的字符是："+str1);

    }
}
