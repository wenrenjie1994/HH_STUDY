**Arrays工具类笔记**  

----------


**一、数组工具类Arrays**  
java.util.Arrays是一个与数组相关的工具类，里面提供了大量静态方法【也就是说直接通过类名来调用就可以】，用来实现数组常见的操作  

    1.public static String toString(数组)：将参数数组变成字符串（按照默认格式：[元素1, 元素2,...]）  
    2.public static void sort(数组)：按照默认升序对数组的元素进行排序  

备注：  
a.如果是数值，sort默认按照数值大小升序排序  
b.如果是字符串，sort默认按照字母列表升序排序  
c.如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持  

**二、Arrays练习_字符串倒序**  
Demo01ArraysPractice.java  

    package demo;  
      
    import java.util.Arrays;  
      
    /*   
    题目：使用Arrays相关的API，将一个随机字符串中的所有字符升序排序并倒序打印  
     */  
    public class Demo01ArraysPractice {  
        public static void main(String[] args) {  
            String str = "a5vrAvq1rANLJN2FVAsdvFard";  
            char[] c1 = str.toCharArray();  
            Arrays.sort(c1);  
            for (int i = c1.length - 1; i >= 0; i--) {  
                System.out.print(c1[i] + " ");  
            }  
        }  
    }  