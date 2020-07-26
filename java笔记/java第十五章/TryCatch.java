package basic.method.demo1.day13;

import java.util.List;

public class TryCatch {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
//            System.out.println(arr[3]);
            List<Integer> lis = List.of(1, 2, 3);
            System.out.println(lis.get(3));
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
}
