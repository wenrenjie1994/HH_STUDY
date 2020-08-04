package fu.day04.demo09;
/*

程序当中所有的双引号字符串，都是String类的对象，（就算没有new,也照样是）

字符串的特点：
1.字符串的内容用不可变。【重点】
2.正是因为内容用不可变，所以字符串是可以共享使用的。
3.字符串效果上相当于是char[]字符数组，但是底层原理是byte[]字节数组

创建字符串常见的3+1种方法
3种构造方法：
public String();创建一个空白字符串，不会有任何内容。
public String(char[] array);根据字符数组的内容，来创建对应的字符串
public String(byte[] array);根据字节数组的内容，来创建对应的字符串
 1种直接创建：
 String str = "hello"

 字符串常量池：程序当中使用双引号创建的
 */
public class DemoString {
    public static void main(String[] args) {
        //使用空参构造
        String str1=new String();//小括号留空，说明字符串什么内容都没有
        System.out.println("1."+str1);

        //根据字符数组的内容
        char[] charArray={'A','B','C'};
        String str2=new String(charArray);
        System.out.println("2."+str2);


        //据字节数组的内容
        byte[] byteArray={97,98,99};
        String str3=new String(byteArray);
        System.out.println("3."+str3);

        //对于引用类型，==进行的是地址值的比较
        //双引号直接写的字符串在常量池中，new的不在池当中
        String str4="abc";
        String str5="abc";
        char[] charArray1={'a','b','c'};
        String str6=new String(charArray1);
        System.out.println(str4=str5);//true
        System.out.println(str4=str6);//false
        System.out.println(str5=str6);//false

        //如果需要进行字符串内容的比较，可以使用两个方法：
        /*1.public boolean equals(Object obj);参数可以是任何对象。
          只有参数是一个字符串并且内容相同时，才回返回true，否则返回false
         注意：1》任何对象都能用Object进行接收
              2》equals方法具有对称性，也就是 a.equals(b) 和 b.equals(a)效果一样
              3》如果比较双方一个常量一个变量，推荐把常量字符串写在前面
              推荐： ”abc“.equals(str)   不推荐：str.equals("abc")

          2.public boolean equalsIgnoreCase(String str)
            忽略大小写，进行内容的比较
                */
        System.out.println(str4.equals(str5));//true
        System.out.println(str5.equals(str6));//true
        System.out.println(str6.equals("abc"));//true
        System.out.println("abc".equals(str4));//true

        String str7=null;
        System.out.println("abc".equals(str7));//推荐，false
        System.out.println(str7.equals("abc"));//不推荐，报错，空指针异常

        System.out.println("============");

        String strA="jave";
        String strB="Jave";
        System.out.println(strB.equals(strA));//false
        System.out.println(strB.equalsIgnoreCase(strA));//true




    }
}
