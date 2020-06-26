# IDEA

## 配置

- [官方文档](https://www.jetbrains.com/help/idea/discover-intellij-idea.html)

### 配置内存

- 路径，关键是 `安装路径\bin\idea.bat` 中 **VM_OPTIONS_FILE** 指向的地址，因版本不同包括但不限于以下路径
  - `安装路径\bin\idea64.exe.vmoptions`
  - `C:\Users\用户名\.IntelliJIdea2019.3\config`
  - `C:\Users\用户名\AppData\Roaming\JetBrains\IntelliJIdea2020.1`
- 选项
  - Xms
  - Xmx
  - XX:ReservedCodeCacheSize

## 项目结构

### 结构

- IDEA 的 Project 类似于 Eclipse 的 workspace
- IDEA 的 Module 类似于 Eclipse 的 project
  - 单 Module 项目中，Module 和 Project 等价
  - 多 Module 项目中，Project 由多个 Module 构成
- 新建 Project 的时候就会同时新建第一个 Module

![image-20200606192530973](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606192530973.png)

### 平台

- 设置全局的 JDK 的路径

![image-20200606203225115](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606203225115.png)

### Project  项目

- 更改项目名称
- 更改项目的 JDK 版本

![image-20200606202930750](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606202930750.png)

### Module 模块

- 更改模块的名称、JDK 版本
- 增加、删除模块

![image-20200606203053901](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606203053901.png)

- 添加模块的依赖包

![image-20200606203128125](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606203128125.png)
## 省电模式

- 菜单栏 → 文件
- **如果运行性能缓慢注意是否打开省电模式**

![image-20200606200146007](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606200146007.png)

## 设置

### 汉化

- 官方中文：Setting → Plugins → 搜索 Chinese
- 第三方：[第三方汉化包](https://github.com/pingfangx/TranslatorX)

### 代码主题

- [下载地址1](http://www.riaway.com)
- [下载地址2](http://color-themes.com)

### 字体

#### 界面的字体

- 外观和行为

![image-20200606194429184](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606194429184.png)

#### 编辑器和代码字体

- 编辑器 → Font：设置全局的字体
- 编辑器 → 颜色和字体：根据主题，针对性设置

![image-20200606194150127](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606194150127.png)

#### 滑轮修改字体大小

- 编辑器 → 编辑器

![image-20200606194555470](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606194555470.png)

#### 复制富文本字体

- 编辑器 → 编辑器

![image-20200606194707012](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606194707012.png)

### 自动导包

- 编辑器 → 编辑器 → 自动导入

![image-20200606194951697](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606194951697.png)

### 显示行号和方法分隔符

- 编辑器 → 编辑器 → 外观

![image-20200606195124061](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606195124061.png)

### 编码

- 编辑器 → File Encoding

![image-20200606195337936](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606195337936.png)

### 自动编译

- 构建 → 编译器


![image-20200606200021973](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606200021973.png)

### Tab跳出括号

- 编辑器 → 编辑器 → Smart Key

![image-20200606200359987](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606200359987.png)

### 驼峰词

- 编辑器 → 编辑器 → Smart Keys
- 选中会导致双击单词时选中部分

![image-20200606202633012](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606202633012.png)

### 模板

- 快速创建内容

#### 文件模板（头部信息）

- 编辑器 → File and Code Templates

![image-20200606195506150](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606195506150.png)

##### 自定义文件信息

![image-20200606195607786](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606195607786.png)

#### 代码模板

- 编辑器 →  活动模板
- 用于快速生成代码块

![image-20200606200756989](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606200756989.png)

| 缩写 | 转换后 | 备注 |
| - | - | - |
| main | 略 | 主方法 |
| sout | System.out.println() | 字符串输出 |
| soutv | 略 | 输出字符串值，用后缀更好 |
| soutp | System.out.println("参数名 = [" + 参数名 + "]") | 输出当前字符串的参数 |
| soutm | System.out.println("类名.方法名") | 输出当前方法名 |
| fori | for循环 | 需要手写上限 |
| iter | foreach循环 | 用后缀更好 |
| ifn | if(xxx==null | 判断为null |
| ifnn |if(xxx!=null | 判断不为null |
| prsf | 私有静态最终 ||
| psf | 公有静态最终 ||
| psfi | 公有静态int常量 ||
| psfs | 公有静态String常量 ||

##### 自定义代码模板

- 借鉴已有模板，变量的使用

![image-20200606201734514](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606201734514.png)

#### 后缀模板

- 编辑器 →  编辑器 → Postfix Completion

![image-20200606201449391](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606201449391.png)

| 后缀名   | 修改前   | 修改后                   | 备注        |
| -------- | -------- | ------------------------ | ----------- |
| cast     | o.cast   | (() o)                   | 对象强转    |
| for/iter | 数组.for | for(int value : 数组) {} | foreach语句 |
| fori | int变量.fori | for (int i = 0; i < int变量; i++) {} | for循环|
| if | boolean表达式.if | if （boolean表达式）{} | if语句|
| else | boolean表达式.else | if (!boolean表达式）{ | if(!)语句 }|
| new | 类名.new | new 类名() | 实例化|
| sout | 变量.sout | System.out.println(b) | 字符串输出|
| soutv | 变量.soutv | System.out.println("b = " + b) | 值输出|
| while | 变量.while | while(变量){} | while语句 |

### Terminal（终端）

- 工具 → 终端
- 可以更改为 CMD, PowerShell, GitBash 等终端

![image-20200606201929212](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606201929212.png)

### 换行

#### 硬换行

- 将一行内容强行分割成两行，各自拥有不同的行号

![image-20200606202152737](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606202152737.png)

#### 软换行／自动换行

- 将一行内容从视觉上分成两行，但实际上是一行

![image-20200606202247400](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606202247400.png)

- 在行号处右键可以快速软换行

![image-20200606202446383](https://martinvon-img.oss-cn-beijing.aliyuncs.com/image-20200606202446383.png)



## 插件安装

### .ignore

- 自动生成忽略文件
    - 可选语言、IDE等

### gitee

- gitee 的插件


### ~~Java Decompiler~~

- 已经自带，会冲突
- 反编译，读Class文件

### Material Theme UI

- [实用教程](https://www.material-theme.com/docs/introduction/)

### Rainbow Brackets

- 彩色括号对
- 设置配色

### CodeMaker

- 自动生成代码
- [教程](https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247487687&idx=2&sn=fd8ba19df3163b4ba4bf0c91f7c5633e&chksm=fa496f76cd3ee660537542c0c0b4162ca835c88de602bf5dd8dbeda01ce423f5aa2f06922280&mpshare=1&scene=23&srcid=&sharer_sharetime=1568602741015&sharer_shareid=670d49968fdd1b7164ecc8a38cf54505#rd)

### Alibaba Java Coding Guidelines

- 代码规范

## 快捷键

| 操作名                       | 快捷键           |
| ---------------------------- | ---------------- |
| **运行**                     | ALT+R            |
| **提示补全**                 | `ALT+/`        |
| 单行注释（反注释）           | CTRL+/           |
| 多行注释（反注释）           | CTRL+SHIFT+/     |
| 文档方法类注释               | 手动输入/**    |
| **万能解错或方法生成返回值** | `ALT+ENTER`      |
| 向下/上复制一行              | CTRL+ALT+↓/↑     |
| 向下/上移动一行              | ALT+↓/↑          |
| 向下新建一行                 | SHIFT+ENTER      |
| 向上新建一行                 | CTRL+SHIFT+ENTER |
| **自动补全后换行**             | `ALT+SHIFT+ENTER` |
| 切换前一个/下一个编辑页面    | ALT+←/→          |
| 查看文档说明                 | F2               |
| **查看继承关系**             | `F4`             |
| 删除当前行或选中行           | CTRL+D           |
| 代码格式化                   | CTRL+SHIFT+F     |
| **查看方法参数类型**         | CTRL+ALT+/       |
| **查看项目结构**(选项卡)    | ALT+1            |
| **查看类结构**(选项卡)          | ALT+2            |
| **方法或类重命名**           | ALT+SHIFT+R      |
| 大小写转换                   | CTRL+SHIFT+Y     |
| **生成**                     | `ALT+SHIFT+S`    |
| **重写方法**                 | CTRL+O           |
| 当前方法展开                 | CTRL+=           |
| 当前方法折叠 | CTRL+- |
| 展开所有方法 | ALT+SHIFT+C |
| 折叠所有方法 | ALT+SHIFT+X |
| **打开代码所在物理文件夹** | CTRL+SHIFT+X |
| **添加if等包围** | ALT+SHIFT+Z |
| **局部变量转全局变量** | ALT+SHIFT+F |
| 选中内容抽取到方法 | ALT+SHIFT+M |
| 查找和替换代码（当前） | CTRL+F |
| 查找代码（全局）|CTRL+H |
| **全局查找** | 按两次 SHIFT |
| 查看类的源代码 | CTRL+左键 or Double SHIFT |
| 查看类的继承结构图 | CTRL+SHIFT+U |
| 关闭当前标签 | CTRL+W |
| 关闭所有标签 | CTRL+SHIFT+W |
| 查找方法在哪里调用 | CTRL+SHIFT+H |
| 添加到收藏夹 | CTRL+ALT+F |
| 最近修改文件 | `CTRL+E` |
| **快速搜索错误** | ALT+SHIFT+Q |
| 打开剪切板 | CTRL+SHIFT+V |
| 构建项目 | CTRL+B |

