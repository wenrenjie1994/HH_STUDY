package day0802.computerUSB;

/**
 * @program: TODO
 * @className:DemoMain
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/8/2 10:33
 **/
public class DemoMain {
    public static void main(String[] args) {
        //1.创建一个笔记本
        Laptop laptop = new Laptop();
        //2.笔记本开机
        laptop.powerOn();
        System.out.println("==============");
        //3.创建并使用USB设备-鼠标
        USB usbMouse = new Mouse();//向上转型
        laptop.useUSBDevice(usbMouse);
        System.out.println("==============");
        //4.创建并使用USB设备-键盘
        KeyBoard usbKeyBoard = new KeyBoard();
        laptop.useUSBDevice(usbKeyBoard);//向上转型
        System.out.println("==============");
        //5.笔记本关机
        laptop.powerOff();
    }
}
