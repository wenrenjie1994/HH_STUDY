package demo06;
/*
基本类型与字符串类型之间的相互转换
基本类型->字符串（String）
1.基本类型的值+""
2.包装类的静态方法toString(参数)，不是Object类的toString()，是重载的关系。
static Sting toString(int i)返回一个表示指定整数的String对象
3.String类的静态方法valueOf(int i) 返回int参数的字符串表示形式
字符串（String）->基本类型
使用包装类的静态方法parseXXX("字符串");
Integer 类：static int parseInt(String s);
Double 类：static double parseDouble(String s);
*
* */
public class Demo3Integer {
    public static void main(String[] args) {
        //基本类型->字符串
        int i1=100;
        String s1=i1+"";
        System.out.println(s1+200);//100200

       String s2= Integer.toString(100);
       System.out.println(s2+200);//100200

       String s3=String.valueOf(100);
       System.out.println(s3+200);//100200

        //字符串->基本类型
        int i=Integer.parseInt(s1);
        double d=Double.parseDouble("1.36");
        System.out.println(i-10);
        System.out.println(d+1.33);
    }
}
