**String类笔记**  

----------


**一、字符串概述和特点**  
1.字符串概述：java.lang.String类代表字符串  
Java API文档解释：Java程序中的所有字符串字面值（如"abc"）都作为此类的实例实现；即程序当中所有的双引号字符串，都是String类的对象（尽管没有new）  
2.字符串的特点：  
a.【字符串的内容永不可变】  
b.正是因为字符串不可改变，所有字符串是可以【共享使用】的  
c.字符串效果上相当于是char[]字符数组，但是底层原理是byte[]字节数组  

**二、字符串的构造方法和直接创建**  
创建字符串的常见3+1种方式：  
三种构造方法：  

    public String()：创建一个空白字符串，不含有任何内容  
    public String(char[] array)：根据字符数组的内容，来创建对应的字符串  
    public String(byte[] array)：根据字节数组的内容，来创建对应的字符串  

一种直接创建： 

    String str = "Hello";//右边直接用双引号  

注意：直接写上双引号，没有new，也是字符串对象  

**三、字符串的常量池\***  
字符串常量池：程序当中直接写上的双引号字符串（直接创建）就放在字符串常量池中；也即只有直接创建的字符串才放在字符串常量池中  
注意：  
1.对于基本类型来说，==是进行数值的比较；对于引用类型来说，==是进行【地址值】的比较  
2.双引号直接写的字符串在常量池当中，new的不在池当中  

**四、字符串的比较相关方法**  
==是进行对象的地址值比较，如果需要对字符串的内容进行比较，可以使用两个方法：  

    1.public boolean equals(Object obj)：参数可以是任何对象，只有参数是一个字符串并且内容相同的才会返回true，否则返回false  
注意事项：  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.任何对象都能用Object进行接收  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b.equals方法具有对称性，也就是a.equals(b)和b.equals(a)效果一样  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c.如果比较双方一个常量一个变量，推荐把常量字符串写在前面  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;推荐："abc".equals(str)  不推荐：str.equals("abc")   

    str = null;  
    System.out.println("abc".equals(str)); //false  
    System.out.println(str.equals("abc")); //报错：空指针异常NullPointerException  
    
    2.public boolean equalsIgnoreCase(String str)：忽略大小写进行内容比较  
注意：只有英文字母区分大小写，"一"与"壹"不可以  

**五、字符串的获取相关方法**  
String当中与获取相关的常用方法有：  

    1.public int length()：获取字符串当中含有的字符个数，拿到字符串长度  
    2.public String concat(String str)：将当前字符串和参数字符串拼接成为返回值新的字符串（当前字符串和参数字符串不会改变）  
    3.public char charAt(int index)：获取指定索引位置的单个字符（索引从0开始）  
    4.public int indexOf(String str)：查找参数字符串在本字符串当中首次出现的索引位置，如果没有返回-1  

**六、字符串的截取方法**  
字符串的截取方法：  

    1.public String substring(int index)：截取从参数位置一直到字符串末尾返回新字符串（当前字符串不会改变）  
    2.public String substring(int begin, int end)：截取从begin开始，一直到end结束，中间的字符串  
    备注：[begin, end)，包含左边不包含右边

注意：

    String strA = "Hello";
    String strA = "Java";

"Hello"和"Java"这两个字符串并没有发生改变，只是strA存储的内容由"Hello"的地址值变成了"Java"的地址值

**七、字符串的转换相关方法**  
String当中与转换相关的常用方法有：  

    1.public char[] toCharArray()：将当前字符串拆分成为字符数组作为返回值  
    2.public byte[] getBytes()：获得当前字符串底层的字节数组  
    3.public String replace(CharSequence oldString, CharSequence newString)：将所有出现的老字符串替换成为新的字符串，返回替换之后的结果新字符串  

备注：CharSequence的意思就是说可以接受字符串类型  

**八、字符串的分割方法**  
分割字符串的方法：  

    public String[] split(String regex)：按照参数的规则，将字符串切分成若干部分  

注意事项：split方法的参数其实是一个正则表达式，今后学习  
此处只需记住，如果按照英文句点"."进行分割，必须写"\\."（加上两个反斜杠）  

**九、练习：按指定格式拼接字符**  
Demo05StringPractice.java  

    package demo;  
      
    /*  
    题目：定义一个方法，把数组[1,2,3]按照指定格式[word1#word2#word3]拼接成一个字符串  
     */  
    public class Demo05StringPractice {    
        public static void main(String[] args) {  
            String[] array = {"1","2","3"};  
            System.out.println(fromArraytoString(array));  
        }  
        public static String fromArraytoString(String[] array) {  
            String result = "[";  
            for (int i = 0; i < array.length - 1; i++) {  
                result = result.concat("word" + array[i] + "#");  
            }  
            result = result.concat("word" + array[array.length - 1] + "]");  
            return result;  
        }  
    }  

**十、练习：统计输入的字符串中**  
o06StringCount.java  

    package demo;  
      
    import java.util.Scanner;  
      
    /*  
    题目：键盘输入一个字符串，并且统计其中各种字符出现的次数  
    种类有：大写字母，小写字母，数字、其他  
     */  
    public class Demo06StringCount {  
        public static void main(String[] args) {  
            Scanner sc = new Scanner(System.in);  
            String str;  
            int[] array;  
            System.out.println("请输入一个字符串：");  
            str = sc.next();  
            array = count(str);  
            System.out.println("大写字母：" + array[0] + "个\n" +  
                    "小写字母：" + array[1] + "个\n" +  
                    "数字：" + array[2] + "个\n" +  
                    "其他：" + array[3] + "个");  
        }  
        public static int[] count(String str) {  
            int[] array = new int[4];  
            for (int i = 0; i < str.length(); i++) {  
                if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {  
                    array[0]++;  
                } else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {  
                    array[1]++;  
                } else if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {  
                    array[2]++;  
                } else {  
                    array[3]++;  
                }  
            }  
            return array;  
        }  
    }  
