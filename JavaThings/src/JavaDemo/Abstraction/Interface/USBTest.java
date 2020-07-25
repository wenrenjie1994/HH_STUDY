package JavaDemo.Abstraction.Interface;

public class USBTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        //非匿名实现类的非匿名对象
        Flash flash = new Flash();
        computer.transferData(flash);

        //非匿名实现类的匿名对象
        computer.transferData(new Flash());

        //匿名实现类的非匿名对象
        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("Power on");
            }

            @Override
            public void end() {
                System.out.println("Power off");
            }
        };
        computer.transferData(phone);

        //匿名实现类的匿名对象
        computer.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("mp4 is online");
            }

            @Override
            public void end() {
                System.out.println("turn down");
            }
        });
    }
}

class Computer {
    public void transferData(USB usb) {
        usb.start();

        System.out.println("details!!");

        usb.end();
    }
}

interface USB {
    void start();

    void end();
}

class Flash implements USB {
    @Override
    public void start() {
        System.out.println("beginning");
    }

    @Override
    public void end() {
        System.out.println("over");
    }
}