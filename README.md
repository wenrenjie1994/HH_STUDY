# Learning
## 内容安排

| 安排 | 进度 |
| ----- | ----- |
| 强化对面向对象中七种软件设计原则的学习和认知 | ✔︎ |
| 结合算法题巩固Java基础 | 持续进行中 |
| 进一步学习和巩固Java中的23种设计模式，争取能够达到灵活应用，提高代码的复用性和可维护性 | ✔︎ |
| 在学习过程中进一步强化对反射等知识的掌握，解决一些实际问题，如执行某个类中全部以test开头的无参数无返回值的非静态方法 | ✔︎ |

**Spring中常用的设计模式总结**

| 设计模式 | 一句话归纳 | 示例 |
| ----- | ----- | ------ |
| 工厂模式(Factory) | 只对结果负责，封装创建过程 |  BeanFactory、Calender |
| 单例模式(Singleton) | 只对结果负责，封装创建过程 | ApplicationContext、Calender |
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
| OOP | Object Oriented Programming(面向切面编程)，用程序归纳总结生活中的一切事物 |  封装、继承、多态 |
| BOP | Bean Oriented Programming(面向Bean编程)面向Bean(普通的Java类)设计程序 | 一切从Bean开始 |
| AOP | Aspect Oriented Programming(面向切面编程)找出多个类中有一定规律的代码，开发时拆开，运行时再合并。面向切面编程，即面向规则编程 | 解耦，专人做专事 |
| IOC | 找人办事，增强职责。Inversion Of Controller(控制反转)将new对象的动作，交给Spring管理，并由Spring保存已创建的对象(IOC容器) | 转交控制权(即控制权反转) |
| DI/DL | Dependency Injection(依赖注入)或者Dependency Lookup(依赖查找)依赖注入，依赖查找，Spring不仅保存自己创建的对象，而且保存对象与对象之间的关系。注入即赋值，主要有三种方式：构造方法、set方法、直接赋值。 | 赋值 |
                                                                        
                        
                        
                           
                                            
                            
                                             
                       
                    
