## HR_SYS

### 使用

```Java
  public static void main(String[] args) {
    // new Config(); 内存读写
    // new Config().setLocalPersistence(true); 内存读写持久化
    // new Config().setUseDB(true); 使用数据库
    // new Config().setCS(true); C/S 分离，需要启动 sys/ServerApplication

    Config config = new Config().setCS(true);
    new HRApplication(config).run();
  }
```



### 草稿（deprecated）



现在提供了 Config 类在启动时注入，可以实现应用的功能切换。

如下启动类：

```Java
// HRApplication.java
public class HRApplication extends AbstractHRApplication {

  public static void main(String[] args) {
    // 当 localPersistence 为 false、useDB 为 false，使用内存保存数据且不持久化
    // 当 localPersistence 为 true、useDB 为 false，使用内存保存数据并使用 txt 文件持久化
    // 只要 useDB 为 true，使用数据库读写数据，不考虑持久化
    new HRApplication(new Config(false, true)).run();
  }
}

// Config.java
public Config(boolean localPersistence, boolean useDB) {
  this.localPersistence = localPersistence;
  this.useDB = useDB;
}
```

### 分析

### C/S

得自己实现 C/S 交互，定义信息交互格式。

入参：`/api/listResume` + Resume 对象（或 ）



返回值：

```Json
Result{
  code : xxx,
  data: xxx
}
```



用户 -》 界面（输入数据）-》【Client】-》【Server】接受数据 -》 Service 层 -》 Mapper 层……

现在 Client 的概念还不包括界面。界面还是先用终端吧。

**坑**：

* Client 与 Server 的 in 与 out 顺序似乎有要求
* 服务端的 in 和 out 得用单例，不然报错 invalid stream header

### 其它

HR 端操作，对应聘人员的简历信息进行管理。

* 应聘人员的简历（Resume）——》扩展性
  * 主要信息
    * 名字
    * 电话
    * 学校
    * 技能
    * ……之类的
  * 系统方面的信息
    * isDelete
    * isVIP
    * ……之类的？

* 权限管理——》暂无
* 数据的持久化（做个导入导出）——》或者把数据的操作抽象化
  * AbstractResumeMapper
    * 增删改查
  * MemoryResumeMapper
    * 增删……
  * TxtResumeMapper
    * 增删……

