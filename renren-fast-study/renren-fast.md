学习renren-fast
后台地址：https://gitee.com/renrenio/renren-fast 
前端地址：https://github.com/daxiongYang/renren-fast-vue 
代码生成器：https://gitee.com/renrenio/renren-generator 
官方社区：http://www.renren.io
错误解决记录：
1、node版本采用的是v12.16.3,此时需要安装pytho2.7,由于此前安装了python3.7,在配置环境变量时未解决两者兼容
（将python3环境变量替换为python2，但是未起作用，从打印日志中得知先从path中找python,如果未找到，
 则存在默认路径C:\\Python2\python.exe，最后将python2安装在此默认路径）

2、运行时出错提示解决办法“npm rebuild node-sass --force”，引起错误原因为：node与sass版本差异，通过rebuild但是报错，先uninstall,然后通过如下语句解决
npm install --save node-sass --registry=https://registry.npm.taobao.org --disturl=https://npm.taobao.org/dist --sass-binary-site=http://npm.taobao.org/mirrors/node-sass

3、通过代码生成器生成的代码引入进renren-fast系统：
   （1）、执行sql语句，即添加菜单
   （2）、将main中的代码与renren-fast系统中main代码合并
   （3）、将main中的.vue文件引入到renren-fast-vue中