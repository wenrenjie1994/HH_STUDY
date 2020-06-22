## 常用注解

@RestController

@RequestMapping("/api")

@Autowired

@PostMapping(value = "/login")

@ResponseStatus(HttpStatus.OK)

@RequestParam("email") String email

@RequestParam("password") String password

//    NotNull 绑定参数校验 用 RequestVaria
//    @PathVariable 是从一个URI模板里面来取值（/后面?之前）
//    @RequestParam 是从request里面取值（？之后）

## 自动注入

同一接口有多个实现类。

```Java
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

