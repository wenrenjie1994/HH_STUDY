package fu.day04.demo13;

public interface MyInterfacePrivateA {
    public default void methodDefault1(){
        System.out.println("默认方法1");
       // methodCommon();

    }
    public default void methodDefaultB(){
        System.out.println("BBB");
        //methodCommon();
    }

   /* private void methodCommon(){
        System.out.println("aaa");
        System.out.println("bbb");
    }*/
}
