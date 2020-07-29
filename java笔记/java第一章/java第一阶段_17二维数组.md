## **多维数组**

多维数组可以看成以数组为元素的数组。可以有二维、三维、甚至更多维数组，但是实际开发中用的非常少。最多到二维数组(学习容器后，我们一般使用容器，二维数组用的都很少)。

**【示例】二维数组的声明**

```java
public class Test {
    public static void main(String[] args) {
        // Java中多维数组的声明和初始化应按从低维到高维的顺序进行
        int[][] a = new int[3][];
        a[0] = new int[2];
        a[1] = new int[4];
        a[2] = new int[3];
        // int a1[][]=new int[][4];//非法
    }
}
```

**【示例】二维数组的静态初始化**

```java
public class Test {
    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 }, { 3, 4 }, { 3, 5, 6, 7 } };
        System.out.println(a[2][3]);
    }
}
```



![图7-10 示例7-16内存分配图.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170522/1495422265742305.png)

​												示例 内存分配图





**【示例7-17】二维数组的动态初始化**

```java
import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        int[][] a = new int[3][];
        // a[0] = {1,2,5}; //错误，没有声明类型就初始化
        a[0] = new int[] { 1, 2 };
        a[1] = new int[] { 2, 2 };
        a[2] = new int[] { 2, 2, 3, 4 };
        System.out.println(a[2][3]);
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
        System.out.println(Arrays.toString(a[2]));
    }
}
```

![图7-11 示例7-17运行效果图.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170522/1495422432219476.png)