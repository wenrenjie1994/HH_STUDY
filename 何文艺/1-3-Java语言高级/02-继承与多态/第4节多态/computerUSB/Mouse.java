package day0802.computerUSB;

/**
 * @program: TODO
 * @className:Mouse
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/8/2 10:15
 **/
public class Mouse implements USB{

    @Override
    public void open() {
        System.out.println("打开鼠标");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标");
    }

    public void click() {
        System.out.println("鼠标点击");
    }
}
