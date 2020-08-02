package day0802.computerUSB;

/**
 * @program: TODO
 * @className:KeyBoard
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/8/2 10:37
 **/
public class KeyBoard implements USB{
    @Override
    public void open() {
        System.out.println("打开键盘");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘");
    }

    public void type() {
        System.out.println("键盘输入");
    }
}
