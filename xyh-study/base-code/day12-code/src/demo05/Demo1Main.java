package demo05;
/*
* 案例分析
* 1.usb接口，包含打开设备功能，关闭设备功能
* 2.笔记本类，包含开机功能、关机功能、使用usb设备功能
* 3.鼠标类，要实现usb接口，并具备点击的方法
* 4.键盘类，要实现usb接口，具备敲击的方法
*
* */
public class Demo1Main {
    public static void main(String[] args) {
        Computer computer=new Computer();
        computer.powerOn();
        //向上转型
        USB  usbMouse=new Mouse();
        computer.useDevice(usbMouse);
        //创建一个USB键盘
        KeyBoard keyBoard=new KeyBoard();
        computer.useDevice(keyBoard);//正确写法，向上转换（类似于基本类型的隐式转换）
        computer.powerOff();
    }
}
