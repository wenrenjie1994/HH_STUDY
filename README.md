HRS3.0使用springboot整合mysql开发了增删改查四个后端接口，使用Swagger UI模拟前端进行接口测试。
踩过的坑如下：

1.SpringBoot启动提示找不到或无法加载主类
  解决：rebuild项目

2.报错The server time zone value '�й���׼ʱ��' is unrecognized or represents more than one time zone.
  原因：mysql时区问题
  解决：在MySQL的URL后面加上“?serverTimezone=UTC”
	例如：jdbc:mysql://localhost:3306/spdb?serverTimezone=UTC&characterEncoding=utf-8

3.swagger与springboot版本不一致
  解决：springboot2.3.1对应swagger2.9.1

4.No identifier specified for entity
  解决：model的主键字段加 @Id 注释

5.template might not exist or might not be accessible by any of the configured Template Resolvers
  原因：在controller层请求处理完了返回时，没有使用@RestController或@ResponseBody而返回了非json格式
  解决：使用@RestController注解
