# HH_STUDY
<<<<<<< HEAD
## 分支学习： 
   ###             1、java8实战训练
   ###             2、springBoot的学习
   ###             3、大型网站架构学习
   ###             4、HR系统简易快速入门、第一阶段、基于内存和控制台的简历系统
*  2020-07-02 
   -     第4分支：HR系统第一阶段基本完成，增加简历的增删改查功能。ArrayList<Resume> resumeList 存储简历对象
         分层架构：pojo:Resume简历对象；service:createResume、deleteResume、updateResume、selectResume;
         BUG:循环访问控制台输入流时，存在不等待输入的情况
             int choice = scanner.nextInt()-> java.util.NoSuchElementException
             考虑是由于控制台内程序自动输入空字符，导致出现异常。
* 2020-07-03 
   -     第1分支 java8实战 stream流的处理，基于管道的流的拼接，优化编程代码。
         第3分支 大型网站架构的高可用架构：分层模型
         第4分支 HR系统第二阶段基本完成，控制台版本基于txt文件的数据持久化。扩展ResumeService功能函数接口，为后续数据写入数据库做准备
* 2020-07-04
   -     第4分支 HR系统第三阶段，基于mysql数据库的数据持久化,新增简历
         基本工具：SpringBoot + Mybatis + Maven + Mysql
         插件：spring-boot-maven-plugin + mybatis-generator-maven-plugin               
         完成：1、利用mysql搭建本机数据库，整合idea+mysql，实现数据库可视化访问，简化方法测试。
               2、基于Mybatis实现对数据库的操作映射，将数据库表利用mybatis-generator-plugin插件生成dao层和pojo层对象
               3、基于junit单元测试框架，完成方法测试
               4、实现对数据库的增删改查
               5、搭建完成基本开发框架                           
         踩过的坑：
               1、Junit进行单元测试会自动回滚事务，导致输入数据插入成功却不存储，设置@Rollback(false)关闭事务回滚
               2、mybatis-generator-plugin生成*mapper.xml文件时，多次运行插件，会使xml文件方法重复而不是覆盖，运行时会报resultMap错误。解决方案：删掉重复方法的代码。   
=======
    #分支学习：
            ##1、java8实战训练，了解lambda表达式写法，流的概念
            ##2、springBoot的学习
            ##3、大型网站架构学习
            ##4、HR系统简易快速入门、第一阶段、基于内存和控制台的简历系统

    7-2 第4分支：HR系统第一阶段基本完成，增加简历的增删改查功能。
                ArrayList<Resume> resumeList 存储简历对象
                分层架构 pojo:Resume简历对象
                        service:createResume、deleteResume、updateResume、selectResume;
                BUG: 循环访问控制台输入流时，存在不等待输入的情况
                    int choice = scanner.nextInt()-> java.util.NoSuchElementException
                    考虑是由于控制台内程序自动输入空字符，导致出现异常。

    7-3 第1分支 java8实战 stream流的处理，基于管道的流的拼接，优化编程代码。
        第3分支 大型网站架构的高可用架构：分层模型
        第4分支 HR系统第二阶段基本完成，控制台版本基于txt文件的数据持久化。扩展ResumeService功能函数接口，为后续数据写入数据库做准备

                   
>>>>>>> bc06d8f06da98d569b54a7cdf6a3fe5cdff296ff
