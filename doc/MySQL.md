## Arch 安装 MySQL

安装 AUR 版本：mysql

开源版本：[https://wiki.archlinux.org/index.php/MariaDB_(%E7%AE%80%E4%BD%93%E4%B8%AD%E6%96%87)](https://wiki.archlinux.org/index.php/MariaDB_(简体中文))

初始化：sudo mysqld --initialize --user=mysql --basedir=/usr --datadir=/var/lib/mysql

启动服务：sudo systemctl start mysqld.service

登陆：mysql -uroot -p

Q#v3<fBJgN_3

密码修改：alter user "root"@"localhost" identified by "test998";

用户管理

刷新数据：flush privileges;

## 操作

导入：用 source 命令。

source /home/test.sql