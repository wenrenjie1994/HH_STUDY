package demo02;
/*
面向对象三大特性：封装、继承、多态
1.方法就是一种封装
2.关键字private也是一种封装
封装就是将一些细节信息隐藏

*/
public class Demo02Method {
    public static void main(String[] args) {
        int[] array = {5,15,36,200,300,800};
        int max =getMax(array);
        System.out.println(max);

    }
    public static int getMax(int[] array){
        int max =array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                max =array[i];
            }
        }
        return max;
    }
}
