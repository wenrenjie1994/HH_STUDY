## 常用注解

@RestController

@RequestMapping("/api")

@Autowired

@PostMapping(value = "/login")

@ResponseStatus(HttpStatus.OK)

@RequestParam("email") String email

- `@Controller`
- `@RestController`
- `@RequestMapping`
- `@GetMapping`
- `@PostMapping`
- `@PutMapping`
- `@RequestParam`
- `@PathVariable`

//    NotNull 绑定参数校验 用 RequestVaria
//    @PathVariable 是从一个URI模板里面来取值（/后面?之前）
//    @RequestParam 是从request里面取值（？之后）

注意：`@PathVariable` 路径参数的 URL ，会带来一定的 SpringMVC 的性能下滑。

 [《SpringMVC RESTful 性能优化》](https://tech.imdada.cn/2015/12/23/springmvc-restful-optimize/)

## 自动注入

同一接口有多个实现类。

```Java
// Performance 是 接口
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AudienceConfig.class)
public class PerformanceTest {
  @Autowired
  private Performance performanceImpl;

  @Test
  public void perTest() {
    performanceImpl.perform();
  }
}
```

## Restful API



## 测试



## 全局统一返回

用 切面 来做。

Aspect

一般还是在 Controller 中返回封装类型就好了吧。

这里有点纠结。到底用一个封装的 DTO 类好，还是用 Spring MVC 自带的功能好？

## 全局异常

* ```Java
  ServiceException extends RuntimeException
  ```

* ```Java
  @ControllerAdvice(basePackages = "cn.iocoder.springboot.lab23.springmvc.controller")
  public class GlobalExceptionHandler {
  ```

一个自定义异常类，一个通过 Aspect 定义的全局异常处理类。Handler

## Spring Boot

Spring 的核心之一是 IOC，负责管理 Bean 的生命周期。而 Spring Boot 则是对 Java 应用的生命周期的管理。

- 在 Spring 的年代，我们都是使用 Tomcat 外部容器来实现 Java 应用的运行，Spring 只是其中的一个组件。
- 在 Spring Boot 的年代，我们使用 Spring Boot 来管理 Java 应用的运行，内嵌的 Tomcat 反而成为其中的一个组件。