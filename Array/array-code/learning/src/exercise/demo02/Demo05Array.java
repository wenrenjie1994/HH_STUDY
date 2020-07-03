package exercise.demo02;
//遍历数组
public class Demo05Array {
    public static void main(String[] args) {
        int[] array ={1,2,3,5,6,7,8};
        //原始方式便利
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
        System.out.println(array[5]);
        System.out.println(array[6]);
        //循环遍历
        for(int i=0;i<array.length;i++){//array.fori快捷生成
            System.out.println(array[i]);
        }

    }
}
