package fu.day04.demo02;

public class ArrayParam {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6};
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }

    }
}
