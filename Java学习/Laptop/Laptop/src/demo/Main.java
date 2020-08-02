package demo;

public class Main {
    public static void main(String[] args) {

        //首先创建一个笔记本电脑
        Computer computer = new Computer();
        computer.powerOn();

        //准备一个鼠标，供电脑使用
//      USB usbMouse = new Mouse(); 多态写法
        Mouse mouse = new Mouse();
        USB usbMouse = mouse;//向上转型
        computer.useDevice(usbMouse);//参数是USB类型，正好传递进去的就是USB鼠标

        //创建一个键盘
        Keyboard keyboard = new Keyboard();
        //方法参数是USB类型，传递进去的是实现类对象
        computer.useDevice(keyboard);//正确写法！也发生了向上转型
//        computer.useDevice(new Keyboard()); 也是正确写法

        
        computer.powerOff();
    }
}
