package basic.method.demo1;

public class DemoArray {
    public static void main(String[] args) {
        int [] array = {10,20,30,40,50,60};
        for(int min = 0, max = array.length - 1;min<max;min++,max--){
        int temp = array[min];
        array[min]=array[max];
        array[max]=temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("===============");
        printArray(array);

        System.out.println("============");
        int [] arrayA=calculate(12,13,14);
        for (int i = 0; i < arrayA.length; i++) {
            System.out.println(arrayA[i]);
        }
        System.out.println();
    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static int [] calculate(int a,int b,int c){
        int sum = a+b+c;
        int avg = sum/3;
        int [] array = {sum,avg};
        return array;
    }
}
