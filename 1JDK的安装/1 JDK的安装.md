## 1 JDK简介

> JDK缩写Java Development kit，翻译过来为java开发工具包。它为java程序开发提供了编译和运行环境，所有java程序依赖于它。通过jdk将java程序编写为字节码文件。

JDK一共三个版本：

- J2SE:标准版，主要用于桌面应用程序
- J2EE：企业版，用户开发企业级应用程序比如ERP系统
- J2ME:微缩版，主要用于开发移动设备，嵌入式设备的应用程序

> 下载解压以后如下图所示

![JDK目录](https://imgkr.cn-bj.ufileos.com/1a3d8604-90e0-4a11-a769-a8191a5358db.png)

- bin：存放java的编译器，解析器等工具
- jre: java runtime environment java运行时环境
- jre/bin:java平台所使用的工具或者是可执行程序
- jre/lib:jre在运行时需要的类库，资源文件
- lib:java开发需要的类库，包含核心类库tools.jar，dt.jar
- src.zip:源码

如果需要查看jdk官网详细介绍，可点击当前目录下的README.html


## 2 JDK安装配置

> 安装配置之前，先需要你了解windows下的path是什么意思。

PATH是路径的意思，PATH环境变量中存放的值，就是一连串的路径。不同的路径之间，用英文的分号（;）分隔开(在win10中新建变量单独成一行)。系统执行用户命令时，若用户未给出绝对路径，则首先在当前目录下寻找相应的可执行文件、批处理文件（另外一种可以执行的文件）等。若找不到，再依次在PATH保存的这些路径中寻找相应的可执行的程序文件。系统就以第一次找到的为准；若搜寻完PATH保存的所有路径都未找到，则会显示类似于图一的错误信息。

我们已经知道bin目录下面有着大量的可执行文件，对我们缩写程序进行编译运行，然后我们希望在任意个目录就可以直接操作，而不用每次都切换到bin目录再运行，path作用就在此，配置成功后，可以在任何路径下执行目录完成任务。

点击计算机----属性----高级环境变量，分别设置Path和JAVA_HOME

![JAVA_HOME](https://imgkr.cn-bj.ufileos.com/55ace626-0b25-4b6e-918a-a65fa5b84656.png)

![PATH](https://imgkr.cn-bj.ufileos.com/c077c08a-2b14-4c00-a682-5890ca53bf6e.png)

用户变量与系统变量区别

>  系统环境变量。对全部用户起作用,而用户环境变量仅仅对当前用户起作用。为了减少自己所做的修改对其它人的影响，故设置了系用户变量避免影响其它人。对于现在的配置而言，设置用户变量和系统变量的效果大致相同，只是系统变量的路径排在用户变量的路径之前。如果系统变量path里面包含java命令，用户变量Path里面也包含java命令,则他会优先执行系统变量path路径里面包含的java命令。

## 3 测试

测试java

![java](https://imgkr.cn-bj.ufileos.com/3f8d7b5f-6be6-45ce-aca7-31478a899f9b.png)

测试java -version

![java版本](https://imgkr.cn-bj.ufileos.com/57b85d0f-a73f-4bd5-9ce1-095dd79e398a.png)

## 4 尝试手撕一次

新建文件，命名为HelloWorld.java，编写代码如下

```
public class HelloWorld{
  public static void main(String[] args){
    System.out.println("xiaolan hello world");
  }
}
```
注意：文件名和类名一样哟

win+R javac HelloWorld.java进行编译

![javac编译](https://imgkr.cn-bj.ufileos.com/b8c7e235-0dff-4184-a0b1-5248c7ac5f39.png)

运行

![运行](https://imgkr.cn-bj.ufileos.com/817f2c1b-530b-4af7-bc33-ef945b3211c5.png)

> 每天坚持一点点，进步一点点，也许就更好一点。

persist








