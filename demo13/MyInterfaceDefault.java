package fu.day04.demo13;
/*
从Java 8 开始，接口里允许定义默认方法
格式：
public default 返回值类型 方法名称（）{
}

备注：接口当中的默认方法，可以解决接口升级的问题
 */

public interface MyInterfaceDefault {
    //抽象方法
    public abstract void methodAbs();

    //新添加的抽象方法会导致接口实现类出错
   // public abstract void methodAbaA();

//   新添加的方法，改成默认方法
    public default void methodAbaA(){

        System.out.println("这是新添加的默认方法");
    }
}
