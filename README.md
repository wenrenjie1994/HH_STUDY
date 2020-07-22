# Learning
## 内容安排

| 安排 | 进度 |
| ----- | ----- |
| 强化对面向对象中七种软件设计原则的学习和认知 | ✔︎ |
| 结合算法题巩固Java基础 | 持续进行 |
| 进一步学习和巩固Java中的23种设计模式，争取能够达到灵活应用，提高代码的复用性和可维护性 | ✔︎ |
| 在学习过程中进一步强化对反射等知识的掌握，解决一些实际问题，如执行某个类中全部以test开头的无参数无返回值的非静态方法 | ✔︎ |

**对软件设计七大原则的归纳总结**

| 设计原则 | 一句话归纳 | 目的 |
| -------- | -------- | -------- |
| 开闭原则(Open-Close) | 对扩展开放，对修改封闭 | 减少维护带来的新风险 |
| 依赖倒置原则(Dependency Inversion) | 高层不应该依赖于低层，而应该依赖于抽象 | 更利于代码结构的升级和扩展 |
| 单一职责原则(Simple Responsibility) | 一个类只做一件事情 | 便于理解，提高代码可读性 |
| 接口隔离原则(Interface Segregation) | 一个接口只做一件事情 | 功能解耦，高内聚，低耦合 |
| 迪米特法则(Law of Demeter) | 不该知道的不要知道 | 只和朋友交流，不和陌生人说话，减少代码臃肿 |
| 里氏替换原则(Liskov Substitution) | 子类重写父类方法功能发生改变，不应该影响父类方法的含义 | 防止继承泛滥 |
| 合成复用原则(Composite Reuse) | 尽量使用组合实现代码复用，而不使用继承 | 降低代码耦合度 |

**创建型设计模式归纳总结**

| 设计模式 | 一句话归纳 | 目的 | 生活案例 | 框架源码举例 |
| -------- | -------- | -------- | -------- | -------- |
| 工厂模式(Factory) | 产品标准化，生产高效化 | 封装创建细节 | 实体工厂 | LoggerFactory、BeanFactory |
| 单例模式(Singleton) | 世界上没有相同的两片树叶 | 保证独一无二 | CEO | Calender、Runtime |
| 原型模式(Prototype) | 拔一根猴毛，吹出千万个 | 高效创建对象(读内存) | 克隆 | ArrayList、PrototypeBean |
| 建造者模式(Builder) | 不同结果的配置将由你来决定 | 开发个性配置步骤 | 选配 | StringBuilder、BeanDefinitionBuilder |

**结构型设计模式归纳总结**

| 设计模式 | 一句话归纳 | 目的 | 生活案例 | 框架源码举例 |
| -------- | -------- | -------- | -------- | -------- |
| 代理模式(Proxy) | 没有资源和时间，得找媒婆来帮忙 | 增强职责 | 媒婆 | ProxyFactoryBean、JdkDynamicAopProxy |
| 门面模式(Facade) | 由点及面 | 统一访问入口 | 前台 包工头 | JdbcUtils、RequestFacade |
| 装饰器模式(Decorator) | 他大舅他二舅，都是他舅 | 灵活扩展，同宗同源 | 蛋糕 | BufferedReader、InputStream |
| 享元模式(FlyWeight) | 优化资源配置，减少重复浪费 | 共享资源池 | 全国社保联网 | String、Integer、ObjectPool |
| 组合模式(Composite) | 人在一起叫团伙，心在一起叫团队 | 统一整体和个体 | 组织架构树 | HashMap |
| 适配器模式(Adapter) | 求同存异 | 兼容转换 | 电源适配 | AdvisorAdapter、HandlerAdapter |
| 桥接模式(Bridge) | 约定优于配置 | 不允许用继承 | 桥 | DriverManager |

**行为型设计模式归纳总结**

| 设计模式 | 一句话归纳 | 目的 | 生活案例 | 框架源码举例 |
| -------- | -------- | -------- | -------- | -------- |
| 委派模式(Delegate) | 这个需求给到你，怎么实现我不管 | 只对结果负责 | 授权委托书 | ClassLoader、BeanDefinitionParserDelegate |
| 模板模式(Template) | 流程全部标准化，需要微调请覆盖 | 逻辑复用 | 装大象进冰箱的步骤 | JdbcTemplate、HttpServlet |
| 策略模式(Strategy) | 条条大路通罗马，爱走哪条走哪条 | 把选择权交给用户 | 选择支付方式 | Comparator、InstantiationStrategy |
| 责任链模式(Chain of Responsibility) | 各人自扫门前雪，莫管他人瓦上霜 | 解耦处理逻辑 | 踢皮球 | FilterChain、Pipeline |
| 迭代器模式(Iterator) | 流水线上坐一天，每个包裹扫一遍 | 统一集合访问方式 | 统一刷脸进站 | Iterator |
| 命令模式(Command) | 上行下效 | 解耦请求与处理 | 遥控器 | Runnable、Callable |
| 状态模式(State) | 忽阴忽晴，忽冷忽热 | 绑定状态和行为 | 订单状态跟踪 | Lifecycle |
| 备忘录模式(Memento) | 给我一剂"后悔药" | 备份 | 草稿箱 | StateManageableMessageContext |
| 中介者模式(Mediator) | 联系方式我给你，怎么搞定我不管 | 统一管理网状资源 | 朋友圈 | Timer |
| 解释器模式(Interpreter) | 我想说“方言” | 实现特定语法解析 | 摩斯密码 | Pattern |
| 观察者模式(Observer) | 到点记得通知我 | 解耦观察者与被观察者 | 闹钟 | ContextLoaderListener |
| 访问者模式(Visitor) | 横看成岭侧成峰，远近高低各不同 | 解耦数据结构与数据操作 | KPI考核 | FileVisitor、BeanDefinitionVisitor |

**Spring中常用的设计模式总结**

| 设计模式 | 一句话归纳 | 示例 |
| -------- | -------- | -------- |
| 工厂模式(Factory) | 只对结果负责，封装创建过程 |  BeanFactory、Calender |
| 单例模式(Singleton) | 只对结果负责，封装创建过程 | ApplicationContext |
| 原型模式(Prototype) | 拔一根猴毛，吹出千万个 | ArrayList、PrototypeBean |
| 代理模式(Proxy) | 找人办事，增强职责 | ProxyFactoryBean、JdkDynamicAopProxy、CglibAopProxy︎ |
| 委派模式(Delegate) | 干活算你的(普通员工),功劳算我的(项目经理) | DispatcherServlet、BeanDefinitionParserDelegate |
| 策略模式(Strategy) | 用户选择，结果统一 | InstantiationStrategy |
| 模版模式(Template) | 流程标准化，自己实现定制 | JdbcTemplate、HttpServlet(doService) |
| 适配器模式(Adapter) | 兼容转换头  | AdvisorAdapter、HandlerAdapter |
| 装饰器模式(Decorator) |  包装，同宗同源 | BufferedReader、InputStream、OutputStream、HttpHeadResponseDecorator |
| 观察者模式(Observer) |  任务完成时通知 | ContextLoaderListener |

**Spring中的编程思想总结**

| Spring思想 | 应用场景(特点) | 一句话归纳 |
| -------- | -------- | --------- |
| OOP | Object Oriented Programming(面向对象编程)，用程序归纳总结生活中的一切事物 |  封装、继承、多态 |
| BOP | Bean Oriented Programming(面向Bean编程)面向Bean(普通的Java类)设计程序 | 一切从Bean开始 |
| AOP | Aspect Oriented Programming(面向切面编程)找出多个类中有一定规律的代码，开发时拆开，运行时再合并。面向切面编程，即面向规则编程 | 解耦，专人做专事 |
| IOC | 找人办事，增强职责。Inversion Of Controller(控制反转)将new对象的动作，交给Spring管理，并由Spring保存已创建的对象(IOC容器) | 转交控制权(即控制权反转) |
| DI/DL | Dependency Injection(依赖注入)或者Dependency Lookup(依赖查找)依赖注入，依赖查找，Spring不仅保存自己创建的对象，而且保存对象与对象之间的关系。注入即赋值，主要有三种方式：构造方法、set方法、直接赋值。 | 赋值 |
                                                                        
## HRS
### Version 1.0 （7.21）- 已完成                        
- 将实体模型转换成实体类
- 初步封装数据库连接Connection
- 建立ExamineTypeManager,实现添加考核类别方法
- 采用饿汉式单例写法获取ExamineTypeManager对象
- 建立ExamineTypeController，完成对课程的添加
- 完成查询考核类别列表、添加考核类别、删除考核类别和修改考核类别方法 

### Version 2.0 （7.22）- 已完成                       
- 采用递归读取部门信息
- 完成添加部门
- 重构DbUtil
- 实现了对部门的删除和修改逻辑                           
                                            
                            
                                             
                       
                    
