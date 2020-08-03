package demo06;

import java.util.ArrayList;

/*
*自动装箱与自动拆箱：基本类型的数据和包装类之间可以自动相互转换
*
* */
public class Demo2Integer {
    public static void main(String[] args) {
        /*自动装箱*/
        Integer in=1;
        /*自动拆箱，in是包装类，无法参与基本类型的计算，但可以自动拆箱后计算。
        * in.inValue()+2:自动拆箱
        * in=in.inValue()+2：自动装箱
        * */
        in=in+2;
        System.out.println(in);

        ArrayList<Integer> list=new ArrayList<>();
        //自动装箱
        list.add(1);
        System.out.println(list);
        //自动拆箱
        int a=list.get(0);
        System.out.println(list);
    }
}
