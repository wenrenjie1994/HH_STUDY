## HR_SYS

项目结构还不错，解耦挺到位的。现在提供了 Config 类在启动时注入，可以实现应用的功能切换。

如下启动类：

```Java
public class HRApplication extends AbstractHRApplication {

  public static void main(String[] args) {
    new HRApplication().run();
  }

  public HRApplication() {
    // 当 localPersistence 为 false、useDB 为 false，使用内存保存数据且不持久化
    // 当 localPersistence 为 true、useDB 为 false，使用内存保存数据并使用 txt 文件持久化
    // 只要 useDB 为 true，使用数据库读写数据，不考虑持久化
    super.config = new Config(false, true);
  }
}
```

### 分析

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

