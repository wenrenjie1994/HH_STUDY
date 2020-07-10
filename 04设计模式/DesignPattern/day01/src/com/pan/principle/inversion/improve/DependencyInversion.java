package com.pan.principle.inversion.improve;

public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new Wechat());
    }
}

interface IReceiver {
    public String getInfo();
}


class Email implements IReceiver {
    public String getInfo() {
        return "电子邮件信息：hello，world";
    }
}

class Wechat implements IReceiver {
    public String getInfo() {
        return "微信信息：hello，ok";
    }
}

class Person {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}







