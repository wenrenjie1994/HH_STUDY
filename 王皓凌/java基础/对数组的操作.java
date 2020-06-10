import java.lang.reflect.Array;
import java.util.Arrays;

public class study {
    public static void main(String[] args) {
        int a[] = new int[] { 18, 62, 68, 82, 65, 9 };
        System.out.println("排序之前 :");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("排序之后:");
        System.out.println(Arrays.toString(a));
        System.out.println("68的位置："+Arrays.binarySearch(a,68));
    }
}
