package demo01;
/*
方法定义格式
public static void 方法名称(){
}
调用格式
方法名称();
note：
1.方法定义没有先后顺序
2.方法不能嵌套定义
3.方法执行必须要调用
*/
public class Demo01Method {
    public static void main(String[] args) {
        printMethod();
    }
    public static void printMethod(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
