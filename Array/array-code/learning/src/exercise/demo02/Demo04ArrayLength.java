package exercise.demo02;
//获取数组长度
public class Demo04ArrayLength {
    public static void main(String[] args) {
        int[] array ={1,3,42,60,12,33,45,60,70,88,99};
        int length =array.length;
        System.out.println("数组长度为："+length);
        int[] arrayA=new int[3];
        arrayA= new int[5];//数组长度不能发生改变 内存泄漏
    }
}
