package demo04.Interface;
/*
从java8开始，接口里允许定义默认方法
格式：
public default 返回值类型 方法名称(参数列表){
方法体
}

备注：接口当中的默认方法，可以解决接口升级的问题;也可以拼接函数模型
*/
public interface MyInterfaceDefault {
    //抽象方法
    public abstract  void methodAbs();
    //添加新方法改为默认方法，A和B的实现类无需覆盖重写
    public default void methodDefault(){
        System.out.println("这是添加的默认方法");
    }
}
