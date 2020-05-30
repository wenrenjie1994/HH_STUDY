/**
 * 位运算
 * /*
 * << 左移: 低位补0，高位丢弃
 * >> 右移: 高位补符号位, 低位丢弃
 * >>>无符号右移: 高位补0,低位丢弃
 *
 * 注意事项；
 *     左移：左移n个单位，相当于乘以2^n;
 *     右移: 右移n个单位，相当于除以2^n;
 *
 *     对于移位运算符来说，当操作数超出了字长时，实际移动 n mod 字长 个单位。
 *
 * 练习：
 *     用最有效率的方式写出计算2乘以8的结果
 *     2 << 3
 * */
public class ExpressionDemo3 {
    public static void main(String[] args){
        int a = 192;
        System.out.println(a << 2); // 192 * 4 = 768
        System.out.println(a >> 2); // 192 / 4 = 48
        System.out.println(-a >> 2); // -192 * 4 = -48

        System.out.println(a >>> 2);// 48
        System.out.println(-a >>> 2); // 很大的整数

        System.out.println("-----------------------");
        a = 64;
        System.out.println(a >>> 32);
        System.out.println(a << 32);
        System.out.println(a >> 32);
        System.out.println(a >> 33);
        System.out.println(a >> -31);

    }
}
