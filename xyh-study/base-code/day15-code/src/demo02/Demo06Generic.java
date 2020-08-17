package demo02;

import java.util.ArrayList;
import java.util.Collection;

/*泛型的上限限定：? extends E 代表使用泛型只能是E类型的子类或者E
* 泛型的下限限定：? super E  代表使用泛型只能是E类型的父类或者E
*
* */
public class Demo06Generic {
    public static void main(String[] args) {
        Collection<Integer> list1=new ArrayList<>();
        Collection<String> list2=new ArrayList<>();
        Collection<Number> list3=new ArrayList<>();
        Collection<Object> list4=new ArrayList<>();

        /*类与类之间的继承关系
        * Integer extengds Number
        * Number extends Object
        * String  extengds Object
        * */
        getElement1(list1);
       // getElement1(list2);//报错
        getElement1(list3);
       // getElement1(list4);//报错

        //getElement2(list1);//报错
       // getElement2(list2);//报错
        getElement2(list3);
        getElement2(list4);


    }
    //泛型上限：Number或者Number的子类
    private static void getElement1(Collection<? extends Number> coll) {

    }

    //泛型下限：Number或者Number的父类
    private static void getElement2(Collection<? super Number> coll) {

    }
}
