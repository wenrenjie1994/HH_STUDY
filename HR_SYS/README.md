## HR_SYS

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

