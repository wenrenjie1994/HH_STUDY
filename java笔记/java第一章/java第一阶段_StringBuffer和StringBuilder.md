## **StringBuffer和StringBuilder**

StringBuffer和StringBuilder非常类似，均代表可变的字符序列。 这两个类都是抽象类AbstractStringBuilder的子类，方法几乎一模一样。我们打开AbstractStringBuilder的源码，如示例所示：

**【示例8-11】AbstractStringBuilder 部分源码**

```java
abstract class AbstractStringBuilder implements Appendable, CharSequence {
    /**
     * The value is used for character storage.
     */
    char value[];
//以下代码省略
}
```

   显然，内部也是一个字符数组，但这个字符数组没有用final修饰，随时可以修改。因此，StringBuilder和StringBuffer称之为“可变字符序列”。那两者有什么区别呢?

1. StringBuffer JDK1.0版本提供的类，线程安全，做线程同步检查， 效率较低。

2. StringBuilder JDK1.5版本提供的类，线程不安全，不做线程同步检查，因此效率较高。 建议采用该类。

**· 常用方法列表：**

1. 重载的public StringBuilder append(…)方法

​    可以为该StringBuilder 对象添加字符序列，仍然返回自身对象。

2. 方法 public StringBuilder delete(int start,int end)

​    可以删除从start开始到end-1为止的一段字符序列，仍然返回自身对象。

3. 方法 public StringBuilder deleteCharAt(int index)

​    移除此序列指定位置上的 char，仍然返回自身对象。

4. 重载的public StringBuilder insert(…)方法

​    可以为该StringBuilder 对象在指定位置插入字符序列，仍然返回自身对象。

5. 方法 public StringBuilder reverse()

​    用于将字符序列逆序，仍然返回自身对象。

6. 方法 public String toString() 返回此序列中数据的字符串表示形式。

7. 和 String 类含义类似的方法：

```java
public int indexOf(String str)
public int indexOf(String str,int fromIndex)
public String substring(int start)
public String substring(int start,int end)
public int length() 
char charAt(int index)
```

**【示例】StringBuffer/StringBuilder基本用法**

```java
public class TestStringBufferAndBuilder 1{
    public static void main(String[] args) {
        /**StringBuilder*/
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append((char) ('a' + i));//追加单个字符
        }
        System.out.println(sb.toString());//转换成String输出
        sb.append(", I can sing my abc!");//追加字符串
        System.out.println(sb.toString());
        /**StringBuffer*/
        StringBuffer sb2 = new StringBuffer("中华人民共和国");
        sb2.insert(0, "爱").insert(0, "我");//插入字符串
        System.out.println(sb2);
        sb2.delete(0, 2);//删除子字符串
        System.out.println(sb2);
        sb2.deleteCharAt(0).deleteCharAt(0);//删除某个字符
        System.out.println(sb2.charAt(0));//获取某个字符
        System.out.println(sb2.reverse());//字符串逆序
    }
}
```

   执行结果如图8-11所示：

![图8-11 示例8-12运行效果图.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170524/1495607217517045.png)



## **要点：**

1. String：不可变字符序列。

2. StringBuffer：可变字符序列，并且线程安全，但是效率低。

3. StringBuilder：可变字符序列，线程不安全，但是效率高(一般用它)。