IOC/DI
所有的类都会在Spring容器中登记，告诉Spring你是个什么东西？你需要什么东西？然后Spring会在系统运行到适当的时候，自动把你要的东西主动给你（而不是在一开始实例化所有对象，从而提高的性能）。所有类的创建、销毁都由Spring来控制，也就是说控制对象生命周期的不再是引用他的对象，而是Spring。对于某个具体的对象来说，以前是它自己去控制其他对象；现在是所有对象都由Spring来控制，这就叫IOC/DI（控制反转 或 依赖注入）。
DI是如何实现的呢？Java1.3之后有一个非常重要的特性 Reflection(反射)，它允许程序在运行时动态的生成对象、执行对象的方法、改变对象的属性，Spring就是通过反射来实现自动注入的。
IOC管理的对象，我们称之为Bean对象，Bean对象就是Spring容器初始化、装配、管理的对象；除此之外，Bean对象与程序中的其他对象没有什么区别，IOC是通过Annotation或XML配置文件来实现手动或自动装配Bean以达到实例化Bean、管理Bean之间的依赖关系的目的。

AOP
切面监控，可以监控任何文件，目前普遍用于日志。
代码如下：
@Log4j2
@Aspect
@Component
public class LogAspect {

    /**
     * 功能描述:
     * controller包的切入点
     *
     * @author: liwenyi
     */
    @Pointcut("execution(* com.cuit.controller.*.*(..))")
    public void controllerLog(){}   //签名，可以理解成这个切入点的一个名称

    /**
     * 功能描述:
     * 在所以controller类的所有方法前执行
     *
     * @param joinPoint 1
     * @return: void
     * @author: liwenyi
     */
    @Before("controllerLog()")
    public void beforeMethod(JoinPoint joinPoint){
        StringBuilder sb = new StringBuilder();
        sb.append("method:"+joinPoint.getSignature());
        log.info(sb);
    }
}
@Aspect注释告诉Spring这是个切面类，然后@Compoment将转换成Spring容器中的bean或者是代理bean。 总之要写切面这两个注解一起用就是了。
下面给几个execution例子：
1）execution(public * *(..))——表示匹配所有public方法
2）execution(* set*(..))——表示所有以“set”开头的方法
3）execution(* com.xyz.service.AccountService.*(..))——表示匹配所有AccountService接口的方法
4）execution(* com.xyz.service.*.*(..))——表示匹配service包下所有的方法
5）execution(* com.xyz.service..*.*(..))——表示匹配service包和它的子包下的方法

JoinPoint包含了几个很有用的参数：
Object[] getArgs：返回目标方法的参数
Signature getSignature：返回目标方法的签名
Object getTarget：返回被织入增强处理的目标对象
Object getThis：返回AOP框架为目标对象生成的代理对象

advice的拦截顺序
只有一个Aspect类：
无异常：@Around（proceed()之前的部分） → @Before → 方法执行 → @Around（proceed()之后的部分） → @After → @AfterReturning
有异常：@Around（proceed(之前的部分)） → @Before → 扔异常ing → @After → @AfterThrowing    （大概是因为方法没有跑完抛了异常，没有正确返回所有@Around的proceed()之后的部分和@AfterReturning两个注解的加强没有能够织入）
同一个方法有多个@Aspect类拦截：
单个Aspect肯定是和只有一个Aspect的时候的情况是一样的，但不同的Aspect里面的advice的顺序呢？？答案是不一定，像是线程一样，没有谁先谁后，除非你给他们分配优先级，同样地，在这里你也可以为@Aspect分配优先级，这样就可以决定谁先谁后了。

注意
如果在同一个 aspect 类中，针对同一个 pointcut，定义了两个相同的 advice(比如，定义了两个 @Before)，那么这两个 advice 的执行顺序是无法确定的，哪怕你给这两个 advice 添加了 @Order 这个注解，也不行。这点切记。
对于@Around这个advice，不管它有没有返回值，但是必须要方法内部，调用一下 pjp.proceed();否则，Controller 中的接口将没有机会被执行，从而也导致了 @Before这个advice不会被触发。