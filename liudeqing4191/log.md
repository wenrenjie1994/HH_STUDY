###### 2020/7/11

完成数据库版本

之前只顾着做东西忘记记笔记了orz

今日分的进步

- 记得引入mysql-connector-java-5.1.38.jar库
- input中的next方法并不会像nextLine一样处理换行符的问题，所以要自己处理。感谢陈艺文大佬（https://blog.csdn.net/jediael_lu/article/details/12653513?utm_source=blogxgwz7）

###### 2020/7/3

想用LinkedList实现存储，但是不会写ResumeList类，先用arrylist完成功能吧

###### 2020/7/1

1. 实践大表哥的lowb内存hr系统
    - 修改注释
    - 将process（招聘进度）改为枚举类型(但是失败了，，java的枚举是一种class，实现起来有点麻烦，还没学会，还是先用int吧)
2. 学习设置live template（https://www.jetbrains.com/help/idea/template-variables.html）
    - 新建模板组或者模板
    - $name$设置变量名
    - 然后为其绑定函数
3. 学习java枚举类型（https://blog.csdn.net/qq_35385687/article/details/90147104）
    - ```
      enum-modifiers enum enumname:enum-base
          {
              enum-body,
          }
      ```
###### 2020/6/30

1. 学习git分支（官方book第三章）
   - git branch [name]
   - git checkout name
   - git checkout -b newBranchName
   
2. 学习大表哥的lowb内存hr系统

3. 学习陈艺文大佬给的git学习网站：https://learngitbranching.js.org/?demo=&locale=zh_CN

   交互式学习 挺好玩的

###### 2020/6/29

学习git官方教学book第1、2章。

1. git简介与安装配置
2. git基础
   - 新建仓库
   - add，commit
   - log