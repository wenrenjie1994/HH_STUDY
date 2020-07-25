package fu.day04.demo01;

public class Demo04ArrayErgodic {
    public static void main(String[] args) {
        int[] array={13,34,56,78};

        //原始方法
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println("=========");

        //循环
        int num=array.length;
        for (int i = 0; i < num; i++) {
            System.out.println(array[i]);
        }
        System.out.println("=========");
        //

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
