- ## 引用类型的一般使用步骤

  API里类的使用都是引用类型

  **1.导包**：

  ```
  import 包路径.类名称'
  ```

  如果需要使用的目标类，和当前类位于同一个包下，则可以省略导包语句不写。

  只有`java.lang`包下的内容不需要导包，其他的包都需要import语句

  **2.创建**

  ```
  类名称 对象名 = new 类名称();
  ```

  **3.使用**

  ```
  对象名.成员方法名()
  ```

- ## Scanner类

  **功能：可以实现键盘输入数据，到程序当中。**

  **使用步骤：**

  1.导包

  ```
  import java.unit.Scanner;
  ```

  2.创建

  ```
  Scanner sc = new Scanner(System.in);
  ```

  **备注**：`System.in`代表从键盘进行输入

  3.使用

  获取键盘输入的一个int数字：

  ```
  int num = sc.nextInt();
  ```

  获取键盘输入的一个字符串： 

  ```
  String str = sc.next();
  ```

  **注**：无论键盘输入什么都是字符串，所以获取`String`时`sc.next()`是直接把输入拿来用，而获取`int`时`sc.nextInt()`是把输入的字符串类型转换为`int`型再赋给num

- ## Scanner类实现例子

  - **题目1**：键盘输入两个`int`数字，并求出和值

  ​	   思路： 1.使用`Scanner`来实现键盘输入

  ​					2.`Scanner`的三个步骤：导包，创建，使用`nextInt()`方法

  ​					3.需要两个数字，要用到两次`nextInt()`

  ​					4.得到两个数字，相加

  ​					5.将结果打印输出

  ```
  import.unit.Scanner;//导包，可以在main直接创建时自动生成代码
  
  public static void main(String[] args){
  	Scanner sc = new Scanner(System.in);
  	int a = sc.nextInt();
  	int b = sc.nextInt();
  	int result = a+b;
  	System.out.println("相加结果是"+result);
  }
  ```

  - **题目2**：键盘输入三个`int`数字，然后求出其中的最大值

    思路： 1.使用`Scanner`来实现键盘输入

    ​			 2.`Scanner`的三个步骤：导包，创建，使用`nextInt()`方法

    ​			 3.三个数字，使用三次`nextInt()`方法，得到三个int变量

    ​			 4.无法同时判断三个数字谁最大，应该转换成两个步骤

    ​					4.1首先判断前两个谁最大，拿到前两个中的最大值

    ​					4.2拿着前两个中的最大值，再和第三个数字比较，得到三个数字中的最大值

    ​			 5.打印结果

    ```
    import.unit.Scanner;//导包，可以在main直接创建时自动生成代码
    
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("请输入第一个数字：");
    	int a = sc.nextInt();
    	System.out.println("请输入第二个数字：");
    	int b = sc.nextInt();
    	System.out.println("请输入第三个数字：");
    	int c = sc.nextInt();
    	
    	//首先得到前两个数字当中的最大值
    	int temp = a > b ? a : b;
    	int max = temp > c ? temp : c;
    	System.out.println("最大值是："+ max);
    }		
    ```

- ## 匿名对象

  - 创建对象的标准格式：`类名称 对象名 = new 类名称();`

  - 匿名对象就是只有右边的对象，没有左边的名字和赋值运算符：`new 类名称();`

    ```
    如：new Person();
    使用方法时：new Person().name = "李东海"; //一旦要访问成员变量，就要赋值
    ```

  - **注意事项：**匿名对象只能使用唯一的一次，下次再用不得不再创建一个新对象。

  - **使用建议：**如果确定有一个对象只需要使用唯一的一次，就可以用匿名对象。

  - 用匿名对象来传参

    ```
    public static void main(String[] args){
    	methodParam(new Scanner(System.in));
    }
    public static void methodParam(Scanner sc){
    	int num = sc.nextInt();
    	System.out.println("输入的是："+num);
    }
    ```

  - 匿名对象作为返回值

    ```
    public static void main(String[] args){
    	Scanner sc = methodReturn();
    	int num = sc.nextInt();
    	System.out.println("输入的是："+num);
    }
    public static void methodReturn(){
    	return new Scanner(System.in)
    }
    ```

- ## Random类

  **功能:**用来生成随机数字。

  **使用步骤：**

  1. **导包**

     ```
     import java.util.Random;
     ```

  2. **创建**

     ```
     Random r = new Random(); //小括号中留空即可
     ```

  3. **使用**

     获取一个随机的int数字（范围是int所有范围，有正负两种）：

     ```
     int num = r,nextInt();
     ```

     获取一个随机的int数字（参数代表了范围，左闭右开区间）：

     ```
     int num = r.nextInt(3);//实际上代表的含义是：[0,3),也就是0~2
     ```

- ## Random类实现例子

  - **题目1**：根据int变量n的值，来获取随机数字，范围是[1,n]，可以取到1也可以取到n。

    思路：1.定义一个int变量n，随意赋值

    ​			2.要使用Random：三个步骤，导包、创建、使用

    ​			3.如果写10，那么就是0~9，然而想要的是1~10，可以发现整体+1即可。

    ​			4.打印随机数字

    ```
    public static void main(String[] args){
    	int n = 5;
    	Random r = new Random();
    	int result = r.nextInt(bound：n)+1;//+1若写到括号内，范围将变成0~n与题目要求不符，不可
    	System.out.println(result);
    }
    ```

  - **题目2**：用代码模拟猜数字的小游戏

    思路：1.首先需要产生一个随机数字，并且一旦产生不再变化。用Random的nextInt方法

    ​			2.需要键盘输入，所以用到了Scanner

    ​			3.获取键盘输入的数字，用Scanner当中的nextInt方法

    ​			4.已经得到了两个数字，判断（if）下：

    ​				如果太小了，提示太小了，并重试

    ​				如果太大了，提示太大了，并重试

    ​				如果猜中了，游戏结束。

    ​			5.重试就是再来一次，循环次数不确定，用while（true）。

    ```java
    public static void main(String[] args){
    	Random r = new Random();
    	int randomNum = r.nextInt(bound:100)+1;//[1,100]
    	Scanner sc = new Scanner(System.in);
    	
    	while(true){
    		System.out.println("请输入你猜测的数字：");
    		int guessNum = sc.nextInt();//键盘输入猜测的数字
    		
    		if(guess > randomNum){
    			System.out.println("太大了，请重试");
    		}else if(guess < randomNum){
    			System.out.println("太小了，请重试");
    		}else {
    			System.out.println("恭喜你，猜中了！");
    			break;//如果猜中，不再重试，跳出循环
    		}
    	}
    	System.out.println("游戏结束。");
    }
    ```

- ## ArrayList集合

  1. #### 概述和基本使用

     - 数组的长度不可以改变，但ArrayList集合的长度可以随意变化

     - 对于ArrayList来说，有一个尖括号<E>代表泛型

       泛型：也就是装在集合当中的所有元素，全都是统一的什么类型

       **注意：泛型只能是引用类型，不能是基本数据类型**（下面由基本数据类型如何存储）

       ```java
       //创建了一个ArrayList集合，集合的名称是list，里面装的全部都是String字符串类型的数据
       
       ArrayList<String> list = new ArrayList<>();
       ```

       **备注：从JDK 1.7+开始，右侧的尖括号内部可以不写内容，但是<>本身还是要写的**

  2. #### 常用方法

     - `public boolean add(E e):`向集合中添加元素，参数类型和泛型一致，返回值代表是否添加成功

       **备注：对于ArrayList集合来说，add添加动作一定是成功的，所以返回值可用可不用。但是对于其他集合（今后学习）来说，add添加动作不一定成功。**

     - `public E get(int index):`从集合当中获取元素，参数是索引编号，返回值就是对应位置的元素。**索引值从0开始**

     - `public E remove(int index):`从集合当中删除元素，参数是索引编号，返回值就是被删除掉的元素。

     - `public int size():`获取集合的尺寸长度，返回值是集合中包含的元素个数

     ```java
     public static void main(String[] args) {
     
             ArrayList<String> list = new ArrayList<>();
             System.out.println(list);//输出结果[]
     
             //向集合中添加元素：add
             boolean success = list.add("张三");
             System.out.println(list);//输出[柳岩]
             System.out.println("添加的动作是否成功："+success);//true
     
             list.add("高圆圆");
             list.add("赵又廷");
             list.add("李小璐");
             list.add("贾乃亮");
     
             //从集合中获取元素： get ，索引值从0开始
             String name = list.get(2);
             System.out.println("第二个索引位置："+name);
     
             //从集合中删除：remove 索引值从0开始
             String whoRemoved = list.remove(3);
             System.out.println("被删除的人是："+ whoRemoved);
             System.out.println(list);
     
             //获取集合的长度尺寸，也就是元素的个数
             int size = list.size();
             System.out.println("集合的长度是："+size);
         }
     ```

     遍历集合

     ```java
     public static void main(String[] args) {
     
             ArrayList<String> list = new ArrayList<>();
             System.out.println(list);//输出结果[]
     
             list.add("高圆圆");
             list.add("赵又廷");
             list.add("李小璐");
             list.add("贾乃亮");
     
             for (int i = 0; i < list.size(); i++) { //可以用list.fori快速生成代码
                 System.out.println(list.get(i));
             }
         }
     ```

  3. #### 存储基本数据类型

     **基本类型**						**包装类**（引用类型，包装类都位于java.lang包下）

     byte								Byte

     short							   Short

     int									Integer 【特殊！】

     long								 Long

     float								 Float

     double							 Double

     char								  Character 【特殊！】

     boolean						   Boolea

     从JDK1.5+开始，支持自动装箱、自动拆箱

     自动装箱：基本类型 --> 包装类型

     自动拆箱：包装类型 --> 基本类型

  4. #### 实现与练习

     - 题目：生成6个1~33之间的随机证书，添加到集合，并遍历集合

       思路：1.需要存储6个数字，创建一个集合，<Integer>

       ​			2.产生随机数，需要用到Random

       ​			3.用循环6次，来产生6个随机数字：for循环

       ​			4.循环内调用r，nextInt(int n)，参数是33,0~32，整体再加1才是1~33

       ​			5.把数字添加到集合中：add

       ​			6.遍历集合：for、size、get

     ```java
     public static void main(String[] args) {
     
             ArrayList<Integer> list = new ArrayList<>();
             Random r = new Random();
             for (int i = 0; i <6 ; i++) {
                 int num = r.nextInt(33)+1;
                 list.add(num);
             }
             for (int i = 0; i < list.size(); i++) {
                 System.out.println(list.get(i));
             }
     
         }
     ```

     - 题目：定义以指定格式打印集合的方法（ArrayList类型作为参数），使用{}扩起集合，使用@分隔每个元素。格式参照：{元素@元素@元素}

       思路：主要考察ArrayList作为方法的参数进行传递

       定义方法三要素：

       ​	返回值类型：知识进行打印而已，没有运算，没有结果，所以用void

       ​	方法名称：printArrayList

       ​	参数列表：ArrayList

       ```java
       public static void main(String[] args) {
               ArrayList<String> list = new ArrayList<>();
               list.add("张三");
               list.add("李四");
               list.add("张三丰");
               list.add("张无忌");
               System.out.println(list);
       
               printArrayList(list);
           }
           public static void printArrayList(ArrayList<String> list ){//传的是地址值
               
               System.out.print("{");
               for (int i = 0; i < list.size(); i++) {
                   String name = list.get(i);
                   if(i == list.size()-1){
                       System.out.println(name+ "}");
                   }else{
                       System.out.print(name+ "@");
                   }
               }
               
           }
       ```

       - 题目：用一个大集合存入20个随机数字，然后筛选其中的偶数元素，放到小集合中。

         分析：1.需要创建一个大集合，用来存储int数字<Integer>

         ​			2.随机数字就用Random nextInt

         ​			3.循环20次，把随机数字放入大集合：for循环、add方法

         ​			4.定义一个方法，用来继续进行筛选

         筛选：根据大集合，筛选符合要求的元素，得到小集合

         方法三要素：返回值类型：ArrayList小集合（里面元素个数不确定）

         ​						方法名称：getSmallList

         ​						参数列表：ArrayList大集合（装着20个随机数字）

         ​			5.判断（if）是偶数：num%2==0

         ​			6.如果是偶数，就放到小集合当中，否则不变

- ## String类

  1. #### 概述和特点

     - 程序当中所有字符串字面值（如“abc”）都作为此类的实例实现。

     - 字符串的特点：1.字符串的内容永不可变，一旦创建就不可改变【重点】

       ​							2.正式因为字符串不可改变，所以字符串是可以共享使用的

       ​							3.字符串效果上相当于是char[]字符数组，但是底层原理是byte[]字节数组

  2. #### 创建字符串的常见3+1种方式

     三种构造方法：

     `public String():`创建一个空白字符串，不含有任何内容

     `public String(char[] array):`根据字符数组的内容，来创建对应的字符串

     `public String(byte[] array):`根据字节数组的内容，赖床将对应的字符串

     一种直接创建：`String str = “Hello”;`//右边直接用双引号

     **注意**：直接写上双引号，就是字符串对象

     ```java
     public static void main(String[] args){
         //空参构造
         String str1 = new String();//小括号留空，说明字符串什么内容都没有
         System.out.println("第一个字符串："+str1);
         
         //根据字符数组创建字符串
         char[] charArray = {'A','B','C'};
         String str2 = new String(charArray);
         System.out.println("第二个字符串："+str2);
         
         //根据字节数组创建字符串
         byte[] byteArray = {97,98,99};
         String str3 = new String(byteArray);
         System.out.println("第三个字符串："+str3);
     }
     ```

  3. #### 常量池

     字符串常量池：程序当中直接写上的双引号字符串，就在字符串常量池中。（在堆当中）

     对于基本数据类型来说，==是进行数值的比较

     **对于引用类型来说，==是进行【地址值】的比较**

     ```
     String st1 = "abc";
     String st2 = "abc";
     
     char[] charArray = {'a','b','c'};
     ```

     ![image-20200712164605759](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200712164605759.png)

     **双引号直接写的字符串在常亮池中，new的不在池当中**

  4. #### 字符串的比较相关方法

     对字符串的**内容**比较，可以使用两个方法：

     - `public boolean equals(Object obj)`:参数可以是任何对象，只有参数是一个字符串并且内容相同的才会给true，否则返回false

       注意事项：1.任何对象都能用Object进行接收

       ​					2.equals方法具有对称性，也就是a.equals(b)和b.equals(a)效果一样。

       ​					3.如果比较双方一个常量一个变量，推荐把常量字符串写在前面。

       ​					推荐：“abc”.equals(str)  不推荐：str.equals("abc") 

       ​					当str为null时前能正常运行，后者会报错空指针异常

     - `public boolean equalsIgnoreCase(String str):`忽略大小写，进行内容比较

  5. #### 与获取相关的常用方法

     - `public int length():`获取字符串当中含有的字符个数，拿到字符串长度。**获取字符串长度**
     - `public String concat(String str):`将当前字符串和参数字符串拼接成为返回值新的字符串。**拼接字符串**（原来的字符串没变，是创建了新的字符串，**字符串是常量！**），也可以用+来表示拼接。
     - `public char charAt(int index):`获取指定索引位置的单个字符。（索引从0开始）
     - `public int indxOf(String str):`查找参数字符串在本字符串当中首次出现的索引位置，如果没有则返回-1值

  6. #### 字符串的截取方法

     - `public String substring(int index):`截取从参数位置一直到字符串末尾，返回新字符串

     - `public String substring(int begin,int end):`截取从begin开始，一直到end结束，中间的字符串

       **备注：**[begin,end),包含左边，不包含右边

     **注：字符串是常量，截取后全字符串不发生任何改变！**

  7. #### 字符串与转换相关的常用方法

     - `public char[] toCharArray():`将当前字符串拆分成字符数组作为返回值（当需要对字符串一个字一个字进行检查时，可用该方法）

     - `public byte[] getBytes():`获得当前字符串底层的字节数组

     - `publuc String replace(CharSequence oldString,CharSequence newString):`将所有出现的老字符串替换成新的字符串，返回替换之后的结果新字符串。**字符串的内容替换**（**替换后返回新的字符串**）

       **备注：**CharSequence是一个接口，表示可以接受字符串类型

  8. #### 字符串的分割

     - `public String[] split(String regex)`:按照参数的给足，将字符串且分成若干部分 

       **注意事项：**split方法的参数其实是一个“正则表达式”，如果按照英文句点“.”进行切分，必须写“\\\\\.”(两个反斜杠)

- ## 静态static关键字

  - 一旦使用了**static关键字**，那么这样的内容不再属于对象自己，而是**属于类**的，所以凡是本类的对象，都**共享同一份**

  - #### 修饰方法：

    - 一旦使用static修饰成员方法，那么这就成为了静态方法。静态方法不属于对象，而属于类。

    - **如果没有static关键字，那么必须先创建对象，然后通过对象才能使用它**

    - **如果有static关键字，那么不需要创建对象，然后通过对象才能使用它**

    - 对于静态方法来说，可以通过对象名进行调用（这种写法在编译后悔被javac翻译成为“类名称.静态方法名”），也可以通过类名称来调用（**推荐通过类名称来调用**）

    - 无论是成员变量，还是成员方法。如果有了static，都推荐使用类名称进行调用

    - **对于本类当中的静态方法，可以省略类名称**

    - **注意事项：**

      1. **静态不能直接访问非静态。**

         原因：因为在内存当中是【先】有的静态内容，【后】有的非静态内容。“先人不知道后人，但后人知道先人”

      2. **静态方法中不能用this。**

         原因：this代表当前对象，通过谁调用的方法，谁就是当前对象

  - 方法区中有静态区专门存储静态数据，方法去指向静态区

  - #### 静态内存图

    ![image-20200713170307806](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200713170307806.png)

    **注意事项：**根据类名称访问静态成员变量的时候，全程**和对象没有关系，只和类有关系**。

  - #### 静态代码块

    格式：

    ```
    public class 类名称{
    	static{
    		//静态代码块的内容
    	}
    }
    
    ```

    **特点：**1.当第一次用到本类时，静态代码块执行唯一的一次

    ​			2.静态内容总是优于非静态，所以静态代码块比构造方法先执行

    **静态代码块的典型用途**：用来一次性地对静态成员变量进行赋值

- ## Arrays类

  - `java.util.Arrays`是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作。

  - `public static String toString(数组)：`将参数数组变成字符串（按照默认格式：[元素1，元素2，元素3....]）

  - `public static void sort(数组)：`按照默认升序（从小到大）对数组的元素进行排序。

    **备注：**

    1.如果是数值，sort默认按照升序从小到大

    2.如果字符串，sort默认按照字母升序

    3.如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持。（今后学习）
  
- ## Math类

  - `java.util.Math`类是数学相关的工作类，里面提供了大量的静态方法，完成与数学运算相关的操作。

  - `public static double abs(doubl num):`获取绝对值，有多种重载

  - `public static double ceil(double num):`向上取整（**向正方向**）

  - `public static double floor(double num):`向下取整

  - `public static long round(double num):`四舍五入

  - `Math.PI`代表近似的圆周率常量（double）

  - **题目：**计算在-10.8到5.9之间，绝对值大于6或者小于2.1的整数有多少个？

    **思路：**1.确定了范围，for循环

    ​			2.起点位置-10.8应该转换为-10两种方法，向上（向正方向）取整

    ​				2.1可以使用Math.ceil方法，向上（向正方向）取整

    ​				2.2强转成为int，自动舍弃所有小数位

    ​			3.每一个数字都是整数，所以步进表达式应该是num++，这样每次都是+1的。

    ​			4.如何得到绝对值：Math.abs方法

    ​			5.一旦发现了一个数字，需要让计数器++进行统计
  
- ## Object类

  - java.lang.Object类是类曾是结构的根（最顶层）类。每个类都使用Object作为超（父）类。**所有对象（包括数组）都实现这个类的方法**

  - #### toString方法

    - 返回该对象的字符串表示，也就是会打印对象的地址值
    - 在直接打印对象的名字，其实就是调用对象的toString方法
    - 因为直接打印对象的地址值没有意义，所以需要在类中重写Object类的toString方法，使其打印对象的属性
    - **使用快捷键alt+insert可以直接快速重写**
    - **看一个类是否重写了toString方法，直接打印这个类对应对象的名字即可。**如果没有重写toString方法，那么打印的就是对象的地址值（默认），如果重写了，那么就按照重写的方式打印

  - #### equals方法

    - 默认比较**对象的地址值**，没有意义。所以要重写，使其能比较两个对象的属性

    - **问题：**隐含着一个多态，存在无法使用子类特有的内容的弊端（无法使用属性和方法） Object  obj = p2 = new Person（"古力娜扎",19）;

      **解决办法**：可以使用向下转型（强转）把obj类型转换为Person

      **注意：**要增加判断，防止类型转换时出现异常

      ​			增加判断，直接处理传入参数为null的情况以及传入是本身的情况，以此来增加程序效率（可选）

      ![image-20200724153934069](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200724153934069.png)

    - 也可以使用快捷键alt+insert来快速生成，生成代码如下

      ![image-20200724154225651](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200724154225651.png)

- ## Objects类

  - null是不能调用方法的，会抛出空指针异常

  - Objects类的equals方法：对两个对象进行比较，**防止空指针异常**

    ```
    public static boolean equals(Object a , Object b){
    	return (a == b)||(a != null && a.equals(b));
    }
    ```

    **备注：当两个对象都为null时，会返回true，但不会抛出空指针异常**

- ## Date类

  - 表示特定的瞬间，精确到**毫秒**（千分之一秒，1000毫秒=1秒）

  - **毫秒值的作用**：可以对时间和日期进行计算。可以把日期转换为毫秒进行计算，计算完再把毫秒转换为日期。

  - ![image-20200724160120276](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200724160120276.png)

    ![image-20200724160039846](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200724160039846.png)

  - **注意：**中国属于东八区，会把时间增加8个小时

    ​			时间远点（0毫秒）：1970年1月1日00:00:00 （英国格林威治）

  - #### 常用方法

    1. `Date（）`：获取当前系统的日期和时间
    2. `Date（long date）`：传递毫秒值，把毫秒值转换为Date日期
    3. `long getTime（）`：把日期转换为毫秒值（相当于System.currentTimeMillis()方法）。返回自1970年1月1日00:00:00  GTM以来此Date对象表示的毫秒数

- ## DateFormat类

  - 是**抽象类**，使用时使用`SimpleDateFormat`子类

  - **功能**：是日期/时间格式化子类的抽象类

  - **作用**：格式化：将日期->文本

    ​			解析：将文本->日期

  - #### 成员方法

    1. `String format(Date date)` : 按照指定的模式，把Date日期，格式化为符合模式的字符串

    2. `Date parse（String source）`：把符合模式的字符串，解析为Date日期

       **注意：**`parse`方法声明了一个叫`ParseException`的异常，如果字符串和构造方法的模式不一样，那么程序就会抛出此异常。调用一个跑出了异常的方法，就必须要处理这个异常，要么throws继续抛出这个异常，要么try catch自己处理（用快捷键alt+回车）

- ## SimpleDateFormat类

  ```
  java.text.SimpleDateFormat extends DateFormat
  ```

  - **构造方法**：

    ```
    SimpleDateFormat（String pattern）
    ```

    用给定的模式和默认语言环境的日期格式符号构造`SimpleDateFormat`

    **参数：**传递指定的模式

    **模式：**区分大小写，**模式中的字母不能改，连接模式的符号可以改变**

    ![image-20200724164420386](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200724164420386.png)

- ## Calendar类

  - 是日历类，在Date后出现，替换掉了许多Date的方法。方便获取各个时间属性

  - 是**抽象类**，里面提供了很多操作日历字段的方法（YEAR、MONTH、DAY_OF_MONTH、HOUR）

  - Calendar类无法直接创建对象使用，里面有一个静态方法叫`getInstance（）`，该方法返回了Calendar类的子类对象

    ```
    Calendar c = Calendar.getInstance();//多态
    ```

  - #### 常用成员方法

    1. `public int get(int field):`返回给定日历字段的值

    2. `public void set(int field , int value)`:将给定的日历字段设置为给定值

       同时设置年月日，可以使用set的重载方法

       ```
       c.set(8888,8,8);
       ```

    3. `public abstract void add(int field , int amount):`根据日历的规则，为给定的日历字段**添加或减去**指定的时间量

       amount:正数：增加

       ​			   负数：减少

    4. `public Date getTime():`把日历对象，转换为日期对象

    5. 成员方法的参数：

       int field：日历类的字段，可以使用Calendar类的静态成员变量获取

       public static final int YEAR = 1;  			年

       public static final int MONTH = 2;  	   月

       public static final int DATE = 5;  			月中的某一天

       public static final int DAY_OF_MONTH = 1;  月中的某一天

       public static final int HOUR = 10;  		时

       public static final int MINUTE = 12;  	分

       public static final int SECOND = 13;  	秒

- ## System类

  - System类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作，

  - #### 常用方法：

    1. `public static long currentTimeMillis()`:返回以毫秒单位的当前时间。多用于判断程序的效率

       ![image-20200725132125282](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200725132125282.png)

    2. `public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length):`将数组中指定的数据拷贝到另一个数组中

       **参数：**src	-	源数组

       ​			srcPos	-	源数组中的起始位置（起始索引）

       ​			dest	-	目标数组

       ​			destPos	-	目标数组中的起始位置

       ​			length	-	要复制的数组元素的数量

       ![image-20200725132937745](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200725132937745.png)

- ## StringBuilder类（字符串缓冲区）

  - 字符串缓冲区，可以提高字符串的操作效率（看成一个长度可以变化的字符串），可以改变长度

    ![image-20200726095243987](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200726095243987.png)

  - #### 构造方法

    `StringBuilder():`构造一个不带任何字符的字符串生成器，其初始容量为16个字符

    `StringBuilder(String str):`构造一个字符串生成器，并初始化为指定的字符串内容

    ```
    StringBuilder bu2 = new StringBuilder("abc");//带参数
    ```

  - #### 常用方法

    - `public StringBuilder append(...):`添加任意类型数据的字符串形式，并返回当前对象自身

      ![image-20200726100935580](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200726100935580.png)

      **备注：使用append方法无需接受返回值**

      可以用于**链式编程**（方法返回值是一个对象，可以继续调用方法）

      ```
      bu.append("abc").append(1).append(true).append(8.8).append("中")
      ```

      

    - `public String toString():`将当前StringBuilder对象转换为String对象

  - #### **StringBuilder和String可以相互转换：**

    - **String -> StringBuilder**：可以使用StringBuilder的构造方法

      StringBuilder(String str)构造一个字符串生成器，并初始化为指定的字符串内容

    - **StringBuilder -> String：**可以使用StringBuilder中的toString方法

      public String toString():将当前StringBuilder对象转换为String对象

- ## 包装类

  - #### **概念**

    ​	基本数据类型，使用起来非常方便，但是没有对应的方法来操作这些基本类型的数据，可以使用一个类，把基本类型的数据装起来，在类中定义一些方法，这个类叫做包装类，我们可以使用类中的方法来操作这些基本类型的数据

  - #### 装箱

    - 把基本类型的数据，包装到包装类中（基本类型的数据 -> 包装类）

    - **可用方法**：

      1. **构造方法**（方法上有横线，说明方法过时了）

         - `Integer（int value）`：构造一个新分配的Integer对象，他表示指定的int值

         - `Integer（String s）：`构造一个新分配的Integer对象，它表示String参数所指示的int值

           **注**：传递的字符串，必须是基本类型的字符串，否则会抛出异常。例：“100”正确，“a”抛异常

      2. **静态方法**

         - `static Integer valueOf（int i）：`返回一个表示指定的int值的Integer实例
         - `static Integer valueOf（String s）：`返回保存指定的String的值的Integer对象

  - #### 拆箱

    - 在包装类中取出基本类型的数据（包装类 -> 基本类型的数据）

    - **可用方法：**

      **成员方法：**`int intValue()` 以int类型返回该Integer的值

  - #### 自动装箱与拆箱

    - 基本类型的数据和包装类之间可用自动的相互转换。JDK1.5后的新特性

      ```
      Integer in = 1;//自动装箱
      
      in = in+2;//自动拆箱
      ```

- ## 基本类型与字符串类型之间的相互转换

  - #### 基本类型 -> 字符串（String）

    1. 基本类型的值+“” （工作中常用）

    2. 包装类的静态方法toString（参数），不是Object类的toString()重载

       `static String toString（int i）：`返回一个表示指定整数的String对象

    3. String类的静态方法valueOf（参数）

       `static String valueOf（int i）`：返回int参数的字符串表示形式

  - #### 字符串（String） -> 基本类型

    使用包装类的静态方法`parseXXX("字符串");`

    ​		Integer类：static int parseInt（String s）

    ​		Double类：static double parseDouble（String s）

