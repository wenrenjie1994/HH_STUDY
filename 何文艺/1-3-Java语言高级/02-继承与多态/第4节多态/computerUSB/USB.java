package day0802.computerUSB;

public interface USB {
    //所有的USB设备都具这些功能
    //打开USB设备
    public abstract void open();

    //关闭USB设备
    public abstract void close();
}
