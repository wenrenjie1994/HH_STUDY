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
       // break 结束挡墙循环
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

   - 







##### 二、Java中级



##### 三、Java高级



##### 四、前端部分



##### 五、数据库









##### ///// 实践部分 /////

##### 1、第三方开发

##### 2、实践项目

