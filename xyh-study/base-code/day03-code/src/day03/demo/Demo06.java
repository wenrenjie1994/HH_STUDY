package day03.demo;
/*
获取数组的长度：array.length
遍历数组：对数组中每个元素进行逐一处理
array.fori:自动生成遍历的for循环
*/
public class Demo06 {

    public static void main(String[] args) {
        int [] arrayB={10,20,30,40,50,3,1,2,3,7};
        //获取数组长度
        int len=arrayB.length;
        System.out.println(len);

        int[]arrayC=new int[3];
        System.out.println(arrayC.length);
        //在堆中新建了一个数组；与数组长度在程序运行期间不改变不冲突
        arrayC=new int[5];
        System.out.println(arrayC.length);

        //遍历数组
        for(int i=0;i<len;i++){
            System.out.println(arrayB[i]);

        }

    }
}
