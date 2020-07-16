import java.util.Arrays;

public class shuzu {

    // public static void main(String[] args) {
    // int[] a;// 声明一个引用
    // a = new int[5];// 创建一个数组，并让引用a指向该数组
    // int[] b = new int[5];// 声明的同时，指向一个数组
    // a[0] = 1;
    // a[1] = 2;
    // a[2] = 3;
    // a[3] = 4;
    // a[4] = 5;
    // System.out.println(a.length);//获取数组长度
    // }

    // 获取数组中的最小值
    // public static void main(String[] args) {
    // int[] a = new int[5];
    // a[0] = (int) (Math.random() * 100);
    // a[1] = (int) (Math.random() * 100);
    // a[2] = (int) (Math.random() * 100);
    // a[3] = (int) (Math.random() * 100);
    // a[4] = (int) (Math.random() * 100);

    // System.out.println("数组中的各个随机数是:");
    // for (int i = 0; i < a.length; i++)
    // System.out.println(a[i]);

    // System.out.print("本练习的目的是，找出最小的一个值: ");
    // int minNum = a[0];
    // for(int j = 1;j < a.length;j++)
    // if(minNum > a[j])
    // minNum = a[j];
    // System.out.println(minNum);
    // }

    // 分配空间，同时赋值的两种方法
    // public static void main(String[] args) {
    // int[] a = new int[] { 100, 200, 300, 450 };
    // int[] b = { 100, 200, 300, 450 };
    // }

    // 数组反转
    // public static void main(String[] args) {
    // int[] a = new int[5];
    // a[0] = (int) (Math.random() * 100);
    // a[1] = (int) (Math.random() * 100);
    // a[2] = (int) (Math.random() * 100);
    // a[3] = (int) (Math.random() * 100);
    // a[4] = (int) (Math.random() * 100);
    // for (int i = 0; i < a.length; i++)
    // System.out.print(a[i] + " ");
    // System.out.println();
    // int index = 0;
    // for (int i = 0; i < a.length / 2; i++) {
    // index = a[i];
    // a[i] = a[4 - i];
    // a[4 - i] = index;
    // }
    // for (int i = 0; i < a.length; i++)
    // System.out.print(a[i] + " ");
    // System.out.println();
    // }

    // 使用选择法正排序，然后使用冒泡法倒排序
    // public static void main(String[] args) {
    // int[] a = new int[5];
    // a[0] = (int) (Math.random() * 100);
    // a[1] = (int) (Math.random() * 100);
    // a[2] = (int) (Math.random() * 100);
    // a[3] = (int) (Math.random() * 100);
    // a[4] = (int) (Math.random() * 100);
    // for (int i = 0; i < a.length; i++)
    // System.out.print(a[i] + " ");
    // System.out.println();

    // // 选择法排序
    // for (int i = 0; i < a.length; i++)
    // for (int j = i + 1; j < a.length; j++) {
    // if (a[j] < a[i]) {
    // int temp = a[j];
    // a[j] = a[i];
    // a[i] = temp;
    // }
    // }
    // for (int i = 0; i < a.length; i++)
    // System.out.print(a[i] + " ");
    // System.out.println();

    // // 冒泡排序
    // for (int i = 0; i < a.length; i++)
    // for (int j = 0; j < a.length - 1 - i; j++) {
    // if (a[j] < a[j + 1]) {
    // int temp = a[j];
    // a[j] = a[j + 1];
    // a[j + 1] = temp;
    // }
    // }
    // for (int i = 0; i < a.length; i++)
    // System.out.print(a[i] + " ");
    // System.out.println();
    // }

    // 增加for循环：只能用来取值，不能进行修改
    // public static void main(String[] args) {
    // int values[] = new int[] { 18, 62, 68, 92, 65, 9 };
    // for (int i = 0; i < values.length; i++)
    // System.out.print(values[i] + " ");
    // System.out.println();

    // for (int value : values)
    // System.out.print(value + " ");
    // System.out.println();

    // // 使用增强for循环找出最大值
    // int max = -999999;
    // for (int value : values) {
    // if (value > max)
    // max = value;
    // }
    // System.out.println("最大值是：" + max);
    // }

    // 对两个数组进行复制或者合并
    // public static void main(String[] args) {
    // int []a = new int[]{24,49,23,28,26,67,89};
    // int []b = new int[]{65,70,86,77,43,10};
    // int length = a.length+b.length;
    // int []c = new int[length];

    // System.arraycopy(a, 0, c, 0, a.length);
    // System.arraycopy(b, 0, c, a.length, b.length);

    // for(int value:c)
    // System.out.print(value + " ");
    // }

    // 二维数组
    // public static void main(String[] args) {
    // // 初始化二维数组，
    // int[][] a = new int[2][3]; // 有两个一维数组，每个一维数组的长度是3
    // a[1][2] = 5; // 可以直接访问一维数组，因为已经分配了空间

    // // 只分配了二维数组
    // int[][] b = new int[2][]; // 有两个一维数组，每个一维数组的长度暂未分配
    // b[0] = new int[3]; // 必须事先分配长度，才可以访问
    // b[0][2] = 5;

    // // 指定内容的同时，分配空间
    // int[][] c = new int[][] { { 1, 2, 4 }, { 4, 5 }, { 6, 7, 8, 9 } };
    // }

    // 随机一个5*5数组，并找出最大值和坐标位置
    // public static void main(String[] args) {
    // int[][] a = new int[5][5];
    // for(int i = 0;i<5;i++)
    // for(int j = 0;j<5;j++)
    // a[i][j] = (int)(Math.random()*100);

    // //输出这个二维数组
    // for(int i = 0;i<5;i++){
    // for(int j = 0;j<5;j++)
    // System.out.print(a[i][j]+" ");
    // System.out.println();
    // }

    // //求最大值和坐标
    // int max = -999;
    // int maxVal = -1;
    // int maxCol = -1;
    // for(int i = 0;i<5;i++)
    // for(int j = 0;j<5;j++){
    // if(a[i][j] > max){
    // max = a[i][j];
    // maxCol = i;
    // maxVal = j;
    // }
    // }
    // System.out.println("最大值是："+max);
    // System.out.println("其坐标是：("+maxCol+","+maxVal+")");
    // }

    // Arrays数组类
    // public static void main(String[] args) {
    // //复制函数
    // int[] a = new int[]{18,62,68,82,65,9};
    // int[] b = Arrays.copyOfRange(a, 0, 3);
    // for(int value:b){
    // System.out.print(value + " ");
    // }
    // System.out.println();

    // //转换为字符串
    // String content = Arrays.toString(a);
    // System.out.println(content);

    // //排序
    // System.out.println("排序之前：");
    // System.out.println(Arrays.toString(a));
    // Arrays.sort(a);
    // System.out.println("排序之后：");
    // System.out.println(Arrays.toString(a));

    // //搜索
    // System.out.println("数字62出现的位置是："+Arrays.binarySearch(a, 62));

    // //判断两个数组是否相同
    // int[] c = new int[]{18,62,68,82,65,8};
    // System.out.println(Arrays.equals(a, c));

    // //使用同一个值，填充整个数组
    // int[] d = new int[10];
    // Arrays.fill(a, 5);
    // System.out.println(Arrays.toString(a));
    // }

    // 二维数组进行排序
    // 随机一个5*8数组，并进行排序
    public static void main(String[] args) {
        int[][] a = new int[5][8];
        for(int i = 0;i<5;i++)
            for(int j = 0;j<8;j++)
                a[i][j] = (int)(Math.random()*100);

        //输出这个二维数组
        for(int i = 0;i<5;i++){
            for(int j = 0;j<8;j++)
                System.out.print(a[i][j]+" ");
            System.out.println();
        }

        int[] temp = new int[8];
        for(int i = 0;i<5;i++){
            temp = Arrays.copyOfRange(a[i], 0, 8);
            Arrays.sort(temp);
            a[i] = Arrays.copyOfRange(temp, 0, 8);
        }

        for(int i = 0;i<5;i++)
            System.out.println(Arrays.toString(a[i]));
    }
}