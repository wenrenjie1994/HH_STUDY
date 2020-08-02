package day0802.computerUSB;

/**
 * @program: TODO
 * @className:Laptop
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/8/2 10:19
 **/
public class Laptop {
    //开机
    public void powerOn() {
        System.out.println("笔记本开机");
    }

    //关机
    public void powerOff() {
        System.out.println("笔记本关机");
    }

    //使用USB设备
/*
    1.所有的USB设备都遵循统一的规范（Mouse和KeyBoard都实现了USB接口），生产厂家在生产笔记本时不需要给每一种USB设备都生产一个特定的接口
    2.只要符合这个统一规范的USB设备都能使用这个USB接口与笔记本进行连接
    2.笔记本在使用USB设备时也就并不用关心具体的USB设备是什么
*/
    public void useUSBDevice(USB usb) {
        //打开USB设备
        usb.open();
        //使用USB设备
        if (usb instanceof Mouse) {
            ((Mouse) usb).click();//向下转型
        } else if (usb instanceof KeyBoard) {
            ((KeyBoard) usb).type();//向下转型
        }
        //关闭USB设备
        usb.close();
    }
}
