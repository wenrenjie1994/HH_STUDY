package basic.method.demo1.day6.day7;

public class DemoMain {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();

        Mouse mouse = new Mouse();
        Usb usbMouse = new Mouse();//多态写法

        computer.useDevice(usbMouse);

        Keyboard keyboard = new Keyboard();
        computer.useDevice(keyboard);//方法参数是USB类型，传递进去的是实现类对象，发生了向上转型Z

        computer.powerOff();
    }


}
