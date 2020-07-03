package exercise.demo02;
//exception 数组越界
public class Demo01ArrayIndex {
    public static void main(String[] args) {
        int[] array = {15,20,25,30};
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        //System.out.println(array[4]);越界ArrayIndexOutOfBoundsException
    }
}
