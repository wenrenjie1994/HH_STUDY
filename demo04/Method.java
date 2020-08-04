package fu.day04.demo04;

/*
面向对象的三大特征：封装、继承、多态。
封装性在Java当中的体现
1.方法就是一种封装
2.关键字private也是一种封装
  一旦使用了private关键字进行修饰时，那么本类当中仍然可以随意访问。
  但是，超出了本类范围之外就不能直访问了，

  间接访问private成员变量，就是定义了一对儿getter/setter方法

  必须叫setXxx或者getXxx
  对于getter来说，不能有参数，返回值类型和成员变量对应
  对于setter来说，不能有返回值，参数类型和成员变量对应

封装就是将一些细节信息隐藏起来，对于外界不可见
*/
public class Method {
    public static void main(String[] args) {
        int[] array={5,1,34,45,56};
        int max=getMax(array);
        System.out.println("最大值"+max);

    }
    public static int getMax(int[] array){
        int max=array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }
}
