**ArrayList集合笔记**  


----------


**一、对象数组**  
  
**二、ArrayList集合概述和基本使用**  
1.数组和ArrayList集合的区别：数组的长度不可以发生改变，但是ArrayList集合的长度是可以随意变化的  
2.对于ArrayList来说，有一个尖括号&lt;E&gt;代表泛型  
泛型：也就是装在集合当中的所有元素全都是统一的这个类型  
注意：泛型只能是引用类型，不能是基本类型  
  
注意事项：对于ArrayList集合来说，直接打印得到的不是地址值，而是内容；如果内容为空，得到的就是空的中括号：[]  
  
**三、ArrayList集合的常用方法和遍历方法**  
1.public boolean add(E e)：向集合当中添加元素，参数的类型和泛型一致  ，返回值代表添加是否成功
备注：对于ArrayList集合来说，add添加动作一定是成功的，所以返回值可用可不用；但是对于其他集合来说，add添加动作不一定成功  
2.public E get(int index)：从集合当中获取元素，参数就是索引编号（索引值从0开始），返回值就是对应位置的E类型的元素（只是获取并未删除）  
3.public E remove(int index)：从集合当中删除元素，参数就是索引编号（索引值从0开始），返回值就是被删除掉的E类型的元素  
4.public int size()：获取集合的尺寸长度，返回值是集合中包含的元素个数  
  
**四、ArrayList集合存储基本数据**  
如果希望向集合ArrayList当中存储基本类型数据，必须使用基本类型对应的"包装类"  
    
    基本类型      包装类（引用类型，包装类都位于java.lang包下）  
    byte         Byte  
    short        Short  
    int          Integer  
    long         Long  
    float        Float  
    double       Double  
    char         Character  
    boolean      Boolean  
    
从JDK 1.5+开始，支持自动装箱、自动拆箱  
自动装箱：基本类型 --> 包装类型  
自动拆箱：包装类型 --> 基本类型  
  
**五、ArrayList练习一_存储随机数**  
  
Demo01ArrayListRandom.java  
  
    /*  
    题目：生成6个1-33之间的随机整数，添加到集合，并遍历集合  
     */  
    public class Demo01ArrayListRandom {  
        public static void main(String[] args) {  
            ArrayList<Integer> list = new ArrayList<>();  
            Random r = new Random();  
            for (int i = 0; i < 6; i++) {  
                list.add(r.nextInt(33) + 1);  
            }  
            for (int i = 0; i < list.size(); i++) {  
                System.out.println(list.get(i));  
            }  
        }  
    }  
    
**六、ArrayList练习二_存储自定义对象**  
  
Student.java  
  
    package demo;  
  
    public class Student {  
        String name;  
        int age;  
      
        public String getName() {  
            return name;  
        }  
      
        public void setName(String name) {  
            this.name = name;  
        }  
      
        public int getAge() {  
            return age;  
        }  
      
        public void setAge(int age) {  
            this.age = age;  
        }  
      
        public Student() {  
        }  
      
        public Student(String name, int age) {  
            this.name = name;  
            this.age = age;  
        }  
    }  

Demo02ArrayListStudent.java  
  
    package demo;  
  
    import java.util.ArrayList;  
      
    /*  
    题目：自定义4个学生对象，添加到集合并遍历  
     */  
    public class Demo02ArrayListStudent {  
        public static void main(String[] args) {  
            ArrayList<Student> list = new ArrayList<>();  
            list.add(new Student("张三", 18));  
            list.add(new Student("李四", 16));  
            list.add(new Student("王二", 20));  
            list.add(new Student("李华", 15));  
            for (int i = 0; i < list.size() ; i++) {  
                System.out.println("名字：" + list.get(i).getName() + "，年龄：" + list.get(i).getAge());  
            }  
        }  
    }  
      
**七、ArrayList练习三_按指定格式打印集合**  
  
Demo03ArrayListPrint.java  
  
    package demo;  
      
    import java.util.ArrayList;  
      
    /*  
    题目：定义以指定格式"{元素@元素@元素...}"打印集合的方法（ArrayList类型作为参数）  
     */  
    public class Demo03ArrayListPrint {  
        public static void main(String[] args) {  
            ArrayList<Integer> list = new ArrayList<>();  
            list.add(1);  
            list.add(2);  
            list.add(3);  
            list.add(4);  
            listPrint(list);  
        }  
        public static void listPrint(ArrayList<Integer> list) {  
            for (int i = 0; i < list.size(); i++) {  
                if (i == 0) {  
                    System.out.print("{" + list.get(i) + "@");  
                } else if (i == list.size() - 1) {  
                    System.out.print(list.get(i) + "}");  
                } else {  
                    System.out.print(list.get(i) + "@");  
                }  
            }  
        }  
    }  
      
**八、ArrayList练习四_筛选集合**  
  
Demo04ArrayListReturn.java  
  
    package demo;  
  
    import java.util.ArrayList;  
    import java.util.Random;  
      
    /*  
    题目：用一个大集合存入20个随机数字，然后筛选其中的偶数元素，放到小集合当中  
    要求使用自定义的方法来实现筛选  
     */  
    public class Demo04ArrayListReturn {  
        public static void main(String[] args) {  
            ArrayList<Integer> largeList = new ArrayList<>();  
            Random r = new Random();  
            for (int i = 0; i < 20; i++) {    
                largeList.add(r.nextInt(100));  
            }  
            System.out.println(largeList);  
            System.out.println(getSmallList(largeList));  
        }   
        public static ArrayList<Integer> getSmallList(ArrayList<Integer> largeList) {  
            ArrayList<Integer> smallList = new ArrayList<>();  
            for (int i = 0; i < largeList.size(); i++) {  
                if (largeList.get(i) % 2 == 0) {  
                    smallList.add(largeList.get(i));  
                }  
            }  
            return smallList;  
        }  
    }  
