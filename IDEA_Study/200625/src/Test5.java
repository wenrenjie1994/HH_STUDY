/**
 * @author MartinVon
 * @create 2020-06-27-21:32
 * <p>
 * 测试运算符
 */
public class Test5 {

    public static void main(String[] args) {

        System.out.println(10.0 / 3.0);

        System.out.println(3 % 2);
        System.out.println(3 % -2);
        System.out.println(Math.floorMod(3, 2));
        System.out.println(Math.floorMod(3, -2));

        int i = 1, j = 1;
        System.out.println(i++);
        System.out.println(++j);
    }

}
