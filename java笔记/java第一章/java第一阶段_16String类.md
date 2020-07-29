## String类

1. String类又称作不可变字符序列。

2. String位于java.lang包中，Java程序默认导入java.lang包下的所有类。

3. Java字符串就是Unicode字符序列，例如字符串“Java”就是4个Unicode字符’J’、’a’、’v’、’a’组成的。

4. Java没有内置的字符串类型，而是在标准Java类库中提供了一个预定义的类String，每个用双引号括起来的字符串都是String类的一个实例。



## **String类和常量池**

在Java的内存分析中，我们会经常听到关于“常量池”的描述，实际上常量池也分了以下三种：

**1. 全局字符串常量池(String Pool)**

   全局字符串常量池中存放的内容是在类加载完成后存到String Pool中的，在每个VM中只有一份，存放的是字符串常量的引用值(在堆中生成字符串对象实例)。

**2. class文件常量池(Class Constant Pool)**

   class常量池是在编译的时候每个class都有的，在编译阶段，存放的是常量(文本字符串、final常量等)和符号引用。

**3. 运行时常量池(Runtime Constant Pool)**

   运行时常量池是在类加载完成之后，将每个class常量池中的符号引用值转存到运行时常量池中，也就是说，每个class都有一个运行时常量池，类在解析之后，将符号引用替换成直接引用，与全局常量池中的引用值保持一致。



## String类的常用方法列表

**![图2.png](https://www.sxt.cn/360shop/Public/admin/UEditor/20170522/1495417924711064.png)**

