package exercise.demo02;

public class Memo06ArrayMax {
    public static void main(String[] args) {
        int[] array ={1,6,4,56,8,11,22,6};
        int max =array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        System.out.println("最大值："+max);
    }
}
