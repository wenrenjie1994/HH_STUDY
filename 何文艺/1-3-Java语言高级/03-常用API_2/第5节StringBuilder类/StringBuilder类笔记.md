**StringBuilder类笔记**  

----------


**一、StringBuilder的原理**  
1.String类：字符串是常量，他们的值在创建之后不能更改；字符串的底层是一个被final修饰的数组，不能改变  
进行字符串的相加，内存中就会有多个字符串，占用空间多，效率低下  
private final byte[] value;  

2.StringBuilder类：字符串缓冲区，可以提高字符串的操作效率（看成一个长度可以变化的字符串）；底层也是一个数组，但是没有被final修饰，可以改变长度  
byte[] value = new byte[16];  

StringBuilder在内存中始终是一个数组，占用的空间少，效率高；如果超出了StringBuilder的初始容量16，会自动扩容  

**二、StringBuilder的构造方法和成员方法**  
1.构造方法  

    StringBuilder()：构造一个没有字符的字符串构建器，初始容量为16个字符
    StringBuilder(String str)：构造一个初始化为指定字符串内容的字符串构建器

2.成员方法  

    public StringBuilder append(...)：添加任意类型数据的字符串形式，并返回当前对象自身,也就是this，因此调用append方法无需接收返回值
    链式编程：方法返回值是一个对象，可以继续调用方法
    System.out.println(new StringBuilder().append("456").append("abc").append("中国")); 输出"456abc中国"
    public String toString()：将当前StringBuilder对象转换为String对象

**三、StringBuilder的toString方法**  
StringBuilder和String的相互转换  
String -> StringBuilder ：使用StringBuilder的构造方法StringBuilder(String str)  
StringBuilder -> String ：使用StringBuilder的toString方法  