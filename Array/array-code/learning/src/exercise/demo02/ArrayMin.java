package exercise.demo02;

public class ArrayMin {
    public static void main(String[] args) {
        int[] array ={1,6,4,56,8,11,22,6};
        int min =array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]<min){
                min=array[i];
            }
        }
        System.out.println("最小值："+ min);
    }
}
