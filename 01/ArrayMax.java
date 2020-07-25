package fu.day04.demo01;

public class ArrayMax {
    public static void main(String[] args) {
        int[] array={5,15,30,20,10000};
        int max=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
               max=array[i];
            }
        }
        System.out.println(max);
    }
}
