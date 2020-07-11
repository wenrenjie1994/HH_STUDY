**MySQL安装与使用笔记**  

----------


**一、MySQL的安装**  

**二、MySQL的卸载**  

**三、MySQL的服务启动和关闭**  
MySQL的服务启动和关闭：  
&nbsp;&nbsp;&nbsp;a.我的电脑 -> 管理 -> 服务和应用程序 -> 服务  
&nbsp;&nbsp;&nbsp;b.win + r -> services.msc  
&nbsp;&nbsp;&nbsp;c.管理员身份运行cmd -> net start/stop mysql服务名称  

**四、MySQL登录和退出**  
1.登录：  
&nbsp;&nbsp;&nbsp;a.mysql -u用户名 -p密码  
&nbsp;&nbsp;&nbsp;b.mysql -h连接目标ip -u用户名 -p连接目标的密码  
&nbsp;&nbsp;&nbsp;c.mysql --host=连接目标ip --user=用户名 --password=连接目标的密码  
2.退出：  
&nbsp;&nbsp;&nbsp;a.exit  
&nbsp;&nbsp;&nbsp;b.quit  

**五、MySQL目录结构**  
1.MySQL安装目录  
2.MySQL数据目录（在ProgramData目录中）  
&nbsp;&nbsp;&nbsp;a.配置文件my.ini  
&nbsp;&nbsp;&nbsp;b.数据库：文件夹  
&nbsp;&nbsp;&nbsp;c.表：文件  
&nbsp;&nbsp;&nbsp;d.数据  