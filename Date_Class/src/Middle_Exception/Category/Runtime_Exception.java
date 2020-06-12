package Middle_Exception.Category;

/**
 * @Author lee
 * @Date 2020/6/12 7:15 AM
 * RuntimeException 运行时异常
 * 不是必须进行处理的异常，如：
 * 除数不能为0，ArithmeticException
 * 这类异常过于普遍，不处理也能编译通过
 * 如果这类异常也需要try-catch，那么代码的可读性会降低
 **/


public class Runtime_Exception {
    public static void main(String[] args) {
        //除数不能为0异常，ArithmeticException
        int k = 5/0;
        //数组下标越界异常，ArrayIndexOutOfBoundsException
        int j[] = new int[5];
        j[100] =5;
        //空指针异常，NullPointerException
        String str = null;
        str.length();
    }
}
//编译可以通过，但是不能运行