package basic.method.demo1.day3;
//使用一个大集合存入20个随机数，然后筛选其中的偶数元素，放到小集合当中，要求使用自定义方法实现
import java.util.ArrayList;
import java.util.Random;

public class Demo03ArrayListReturn {


    public static void main(String[] args) {
        ArrayList<Integer> bigList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(100)+1;
            bigList.add(num);
        }
        ArrayList<Integer> smallList = getSmallList(bigList);
        System.out.println("偶数共有多少个"+smallList.size());
        for (int i = 0; i < smallList.size(); i++) {
            System.out.println(smallList.get(i));
        }
    }
    public static ArrayList<Integer> getSmallList(ArrayList<Integer> bigList){
        ArrayList<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < bigList.size(); i++) {
            int num = bigList.get(i);
            if (num%2==0){
                smallList.add(num);
            }
        }
        return smallList;
    }
}