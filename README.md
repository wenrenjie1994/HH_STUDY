# HH_STUDY
    分支学习：
            1、java8实战训练，了解lambda表达式写法，流的概念
            2、springBoot的学习
            3、大型网站架构学习
            4、HR系统简易快速入门、第一阶段、基于内存和控制台的简历系统

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

                   
