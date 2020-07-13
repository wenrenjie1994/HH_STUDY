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

