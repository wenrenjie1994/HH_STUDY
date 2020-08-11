### 进度安排 -java

##### ///// 理论部分 /////

##### 一、Java基础（7.10 - 7. 13）

1. 面向对象
   - 类和对象 
     - 属性：类里面定义的一些变量
     - 方法：在类里面定义的一些内部函数，可以用来实现某些功能
   
2. 变量
   
   - 当一个变量被  **final**  修饰的时候，该变量 **只有一次赋值的机会** 
   
3. 操作符

   - **Scanner** 
     - **import**  java.util.Scanner;
     - next在输入有效字符之前输入的空格，换行，tab都是无效的，在输入有效字符之后输入的空格，换行，tab都是它的结束符 nextLine的开始结束都只有换行，中间输入的空格，tab都会照常输出
   - 逻辑操作符
     - & 、&&		长路与 和 短路与
     - |、||            长路或 和 短路或
   - 位操作符
     - 带符号右移 >>
       - 对于正数，带符号右移 >> 会把所有的位右移，并在最前面补0
       - 对于负数，带符号右移 >> 会把所有的位右移，并在最前面补1
     - 无符号右移  **>>>**
       - 无符号右移  **>>>** 会把第一位的 1 也向右移动，导致移动后，第一位变成0，这样负数在无符号右移后，得到一个正数
     - 带符号右移 >> 移动后正的还是正的，负的还是负的，符号不变；无符号右移 >> 移动后，变正的了
     - 左移 << ：将一个整数的二进制每一位都向左移动，最右边一位补0

4. 控制流程

   - 结束外部循环

     - ```java
       // break 结束外部循环
       public class HelloWorld {
       	public static void main(String[] args) {
               for (int i = 0; i < 10; ++i) {
                   for (int j = 0; j < 10; ++j) {
                       System.out.println(i+":"+j);
                       if(0 == j % 2) break;
                   }
               }
           }
       }
       ```

     - ```java
       // 使用 boolean 变量结束外部循环
       public class HelloWorld {
       	public static void main(String[] args) {
       		boolean breakout = false;
       		for (int i = 0; i < 10; ++j ) {
       			for (int j = 0; j < 10; ++j ) {
       				System.out.println(i + ":" +j);
       				if (0 == j % 2) {
       					breakout = true;
       					break;				
       				}
       			}
       			if (breakout) {
       				break;
       			}
       		}
       	}
       }
       
       ```

     - ```java
       // 使用标签结束外部循环
       public class HelloWorld {
       	public static void main(String[] args) {
       		outloop:
       		for (int i = 0; i <10; ++i) {
       			for (int j = 0; j <10; ++j) {
       				System.out.println(i + ":" + j);
       				if(0 == j % 2) 
       					break outloop;
       			}
       		}
       	}
       }
       ```

5. 数组

   - 声明数组    **int a[]** 或 **int [] a**

     - 数组长度   **a.length**
     - 获取 **0 - 100** 的随机整数：      **(int)(Math.random() * 100)**
     - **Math.random()**  会得到一个 0 - 1 之间的随机浮点数

   - 增强型 for 循环 - 只能用来取值，不能修改数组里面的值

     - ```java
       for (int i : arrayname) {
           **** 
       }
       ```

   - 复制数组

     - ```java
       System.arraycopy(source_array, begin_pos, des_array, begin_pos, length)
       ```

   - **Arrays**

     - |   数组复制   | Arrays.copyOfRange(src_array, begin_pos, end_pos) |
       | :----------: | :-----------------------------------------------: |
       | 转换为字符串 |              Arrays.toString(array)               |
       |     排序     |                Arrays.sort(array)                 |
       |     搜素     |         Arrays.binarySearch(array, value)         |
       | 判断是否相同 |          Arrays.equals(array_a, array_b)          |
       |     填充     |              Arrays.fill(array, num)              |

6. 类和对象

   - 引用 - 变量的类型为类类型，该变量为引用
   
     - ```java 
       public class Hero {
       	public static void main(String[], args) {
               Hero h = new Hero();    // 使用一个引用来指向这个对象
           }
       }
       ```
   
     - 多个引用，一个对象
   
     - 一个引用，多个对象（一个引用，同一时间，只能指向一个对象）
   
   - 继承
   
     - ```java
       // 父类
       public class Item {
           String name;
           int price;
       }
       // 子类
       public class Weapon extends Item {
           int demage;
           ****
       }
       ```
   
   - 方法重载
   
     - 方法名一样，参数类型和个数不一样
   
     - 可变数量的参数 
   
       ```java 
       public void attack(Hero... heros) {
           for (int i = 0; i < heros.length; ++i) 
               ****
       }
       ```
   
   - 构造方法（构造函数）
   
     - 函数名和类名一样，没有返回类型
     - 无参的构造函数，如果不写，就会默认提供一个
     - 提供了有参的构造函数，那么默认的构造函数就没有了
     - 构造函数可以重载
   
   - **this**
   
     - this 代表当前对象
     - this可调用其他的构造方法
     
   - 传参
   
     - 基本类型传参 和 类类型传参
     - **Hero h = new Hero()**   --- 表示引用h，指向一个 Hero 对象
     - 在方法中，是参数引用指向一个新的对象，外面的引用还是指向原来的对象，而非方法内的新对象
   
   - 包（**package**）
   
     - 将较接近的类放到同一个包下，调用不同包的类时，必须 **import**  将另一个包的类导入
   
   - 访问修饰符
   
     - 属性通常用private封装起来；方法用public用于被调用；会被子类继承的方法，通常使用protected；
   
     - 作用范围最小原则；能用private就用private，不行再放大一级
   
       - private：只能自己用
       - package：同包可用，不同包不能使用
       - public：公交车，不论在哪都可用
       - protected：跟你有关系的，比如同一个包，或属于父子关系。跟你没关系的不能用
   
     - |           | 自身 | 同包子类 | 异包子类 | 同包 | 其他类 |
       | :-------: | :--: | :------: | :------: | :--: | :----: |
       |  private  |  ✔   |          |          |      |        |
       |  package  |  ✔   |    ✔     |          |  ✔   |        |
       | protected |  ✔   |    ✔     |    ✔     |  ✔   |        |
       |  public   |  ✔   |    ✔     |    ✔     |  ✔   |   ✔    |
   
   - 类属性
   
     - 一个属性被 **static**  修饰，就叫做 **类属性** ，又叫做 **静态属性**
     - 当一个属性被声明为类属性，所有对象共享一个值（当某个属性可以被所有对象所拥有，则设计为类属性）
     - **对象属性**：又叫实例属性，非静态属性
     - 访问类属性
       - 对象名.类属性
       - 类名.类属性
   
   - 类方法（静态方法，被 **static** 修饰）
   
     - **对象方法** ， 又叫实例方法，非静态方法
     - 访问一个类方法，必须**建立在有一个对象** 的前提上，访问类方法，**不需要对象** 的存在，直接就访问
     - 访问类方法
       - 对象.类方法
       - 类.类方法
     - 在一个类方法中，直接调用一个对象方法，需要传参，传个类对象进去才可以调用对象方法
   
   - 属性初始化
   
     - 对象属性初始化
   
       - 声明属性的时候初始化
   
       - 构造方法中初始化
   
       - 初始化块
   
       - 优先级：声明初始化 -> 初始化块 -> 构造方法
   
       - ```java
         public class Hero() {
             public String name = "some hero";  // 声明时初始化
             
             public Hero() { name = "one hero"; } 	// 构造方法中初始化
             
             { name = "the hero"; }	// 初始化块
         }
         ```
   
     - 类属性初始化
   
       - 声明的时候初始化
   
       - 静态初始化块
   
       - ```java
         public class Hero() {
         	public static int itemCapacity = 8;	// 声明时初始化
         	
         	static { itemCapacity = 8; }	// 静态初始化块
         }
         ```
   
   - 单例模式（Singleton 模式）
   
     - 构造方法私有化
     - 静态属性指向实例
     - public static 的 getInstance 方法，返回第二步的静态属性
   
   - 枚举类型 （**enum** ，特殊的类）
   
     - 方便定义常量
     - 增强型for循环遍历枚举
   
7. 接口与继承

   - 接口
   
     - ```java
       public interface AD {
       	public void physicAttack() ;
       }
       
       public class ADHero extends Hero implements AD {
       	@override 
       	public void physicAttack() {
       		System.out.println("进行物理攻击");
       	}
       }
       ```
   
   - 对象转型
   
     - 子类转父类，都可以转
     - 父类转子类，依情况而定，必须进行强制转换
     - 没有继承关系的两个类互相转换，一定会失败
     - 类转换成接口，可以转换成功
     - 接口转换成类，看有无关系，无关系则无法转换
     - instanceof  **Hero**  判断一个引用所指向的对象
   
   - 重写
   
     - 子类可以继承父类的对象方法，继承后，重复提供该方法，叫做该方法的重写，又叫覆盖 **override** 
   
   - 多态
   
     - 操作符的多态
       - **+**  可以作为算数运算，也可以作为字符串连接
     - 类的多态条件
       - 父类（接口）引用指向子类对象
       - 调用的方法有重写
   
   - 隐藏
   
     - 重写是子类的方法覆盖父类的 **对象方法** 
     - 隐藏是子类覆盖父类的 **类方法**
   
   - Object 
   
     - **Object** 是所有类的父类
     - **toString** 返回当前对象的 字符串表达
     - **finalize** 一个对象没有任何引用的时候，就满足垃圾回收的条件，当它被垃圾回收时，它的finalize() 方法就会被调用
     - **equals() ** 判断两个对象的内容是否相同
     - **==** 用于判断引用是否指向了同一个对象
   
   - **final**
   
     - final 修饰类，该类不能被继承
     - final 修饰方法，该方法在其他类中不能被重写
     - final 修饰基本类型变量，表示该变量只有一次赋值机会
     - final 修饰引用，表示该引用只有 **1次** 指向对象的机会
     - String 类被 final 修饰，不能被继承
   
   - 抽象类
   
     - 再类中声明一个空方法，这样的方法就叫抽象方法，使用修饰符 **abstract** ，有抽象方法时，该类必须被声明为抽象类，子类继承的时候必须重写这个方法
     - 抽象类可以没有抽象方法，此时该类不能被直接实例化
   
8. 数字与字符串

   - 装箱和拆箱
   
   - 字符串转换
     - 数字转字符串
       - 使用String类的静态方法 valueOf()
       - 先把基本类型装箱为对象，后调用对象的 toString()
     - 字符串转数字
       - 调用 integer 的静态方法 parseInt()
     
   - 操纵字符串
   
     - |              charAt              |                           获取字符                           |
       | :------------------------------: | :----------------------------------------------------------: |
       |           toCharArray            |                      获取对应的字符数组                      |
       |            subString             |                         截取子字符串                         |
       |              split               |                             分隔                             |
       |               trim               |                         去掉首尾空格                         |
       |    toLowerCase / toUpperCase     |                            大小写                            |
       | indexOf / lastIndexOf / contains | 定位 (子字符串/字符串第一次出现位置 / 最后一次出现位置 / 是否包含子字符串) |
       |    replaceAll / replaceFirst     |              替换 （替换所有的 / 只替换第一个）              |
   
   - 





##### 二、Java中级



##### 三、Java高级



##### 四、前端部分



##### 五、数据库









##### ///// 实践部分 /////

##### 1、第三方开发

##### 2、实践项目

