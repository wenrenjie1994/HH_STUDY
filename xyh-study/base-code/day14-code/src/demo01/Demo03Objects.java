package demo01;

import java.util.Objects;

public class Demo03Objects {
    public static void main(String[] args) {
        String s1=null;
        String s2="aBc";
        //会抛出空指针移场NullPointerException
        /*boolean b=s1.equals(s2);*/


        /*
        public static boolean equals(Object a, Object b){
            return(a==b)||(a!=null&&a.equals(b))
        }
        */
        // Objects.equals(s1,s2);不会报错，容忍空指针异常
        boolean b= Objects.equals(s1,s2);
        System.out.println(b);
    }
}
