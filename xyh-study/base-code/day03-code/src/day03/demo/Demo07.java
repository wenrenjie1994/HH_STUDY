package day03.demo;
/*数组相关的练习题*/
public class Demo07 {
    public static void main(String[] args) {
        /*求出数组中的最值*/
        int[] array={5,15,20,30,1000,500};
        int max=array[0];
        for(int i=1;i<array.length;i++){
            if(max<array[i]){
                max=array[i];
            }
        }
        System.out.println(max);
        System.out.println("=======================");
        /*数组翻转：不能使用新数组*/
        int Min=0;
        int Max=array.length-1;

        for(int i=0;i<array.length/2;i++){
            int temp=array[Min];
            array[Min]=array[Max];
            array[Max]=temp;
            Min++;
            Max--;
        }
        //打印数组信息
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
