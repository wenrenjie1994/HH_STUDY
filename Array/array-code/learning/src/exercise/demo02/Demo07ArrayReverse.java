package exercise.demo02;
//数组元素反转，只能使用一个数组
//java 没有指针
//数组作为参数和返回值 传入和返回的都是数组的地址
public class Demo07ArrayReverse {
    public static void main(String[] args) {
        int[] array ={1,6,7,8,9,234,56,67};
        printArray(array);
        printArray(arrayReverse(array));
    }
    public static int[] arrayReverse(int[] array){
        int min =0;
        int max= array.length-1;
        while(min<max){
            int temp=array[max];
            array[max]=array[min];
            array[min]=temp;
            min++;
            max--;
        }
        return array;
    }
    //遍历数组
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("");
    }
}
