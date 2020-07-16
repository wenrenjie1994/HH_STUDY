package digit;

public class TestNumber {

    // public static void main(String[] args) {
    // int i = 5;

    // //把一个基本类型的变量，转换为Integer对象
    // Integer it = new Integer(i);
    // //把一个Integer对象，转换为一个基本的类型
    // int i2 = it.intValue();
    // }

    // 数字封装类还有Byte,Short,Integer,Long,Float,Double
    // 这些都是抽象类Number的子类
    // public static void main(String[] args) {
    // int i = 5;
    // Integer it = new Integer(i);
    // //Integer是Number的子类，所以打印true
    // System.out.println(it instanceof Number);
    // }

    // 通过=符号，自动把基本类型转换为类类型就叫装箱
    // 通过=符号，自动把类类型转换为基本类型就叫拆箱
    // public static void main(String[] args) {
    // int i = 5;
    // Integer it1 = i;//装箱

    // Integer it = new Integer(i);
    // int i3 = it;//拆箱
    // }

    // int的最大值和最小值可以通过对应的封装类Integer.MAX_VALUE获取
    // public static void main(String[] args) {

    // System.out.println(Integer.MAX_VALUE);
    // System.out.println(Integer.MIN_VALUE);
    // }

    // 数字转字符串
    // public static void main(String[] args) {
    // int i = 5;

    // //方法1
    // String str = String.valueOf(i);

    // //方法2
    // Integer it = i;
    // String str2 = it.toString(i);
    // System.out.println(str);
    // System.out.println(str2);
    // }

    // 字符串转数字
    // public static void main(String[] args) {
    // // String str = "999";
    // // int i = Integer.parseInt(str);
    // // System.out.println(i);

    // //练习
    // float f = 3.14f;
    // String str = String.valueOf(f);
    // System.out.println(str);

    // String str2 = "3.14";
    // float f2 = Float.parseFloat(str2);
    // System.out.println(f2);
    // }

    // 格式化输出
    public static void main(String[] args) {
        String name = "盖伦";
        int kill = 8;
        String title = "超神";

        // 直接使用+进行字符串连接，编码感觉会比较繁琐，并且维护性差,易读性差
        String sentence = name + " 在进行了连续 " + kill + " 次击杀后，获得了 " + title + " 的称号";

        System.out.println(sentence);

        // 使用格式化输出
        // %s表示字符串，%d表示数字,%n表示换行
        String sentenceFormat = "%s 在进行了连续 %d 次击杀后，获得了 %s 的称号%n";
        System.out.printf(sentenceFormat, name, kill, title);
    }

}