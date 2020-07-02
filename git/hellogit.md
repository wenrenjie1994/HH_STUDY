## git基本操作
### 一、git下载
* 下载地址：https://git-scm.com/downloads
### 二、git使用
### 1、相关配置
* 配置全局用户名：git config --global user.name "github用户名"
* 配置全局邮箱：git config --global user.email "github邮箱"
### 2、设置SSH Key
* 未生成SSH Key：ssh-keygen -t rsa -C github邮箱
* 复制SSH Key：clip < ~/.ssh/id_rsa.pub
* github -> 头像 -> setting -> SSH and GPG keys -> 粘贴SSH key -> add SSH key
* 测试连接：ssh -T git@github.com 
### 3、新建分支并提交
* 克隆项目：git clone  https://github.com/项目名称.git
* 初始化git：git init
* 新建分支并切换：git checkout -b 分支名称
* 连接本地仓库与远程仓库：git remote add origin git@github.com:项目目录.git 
* 添加文件：git add .（新文件与修改文件）；git add -u（修改与删除文件）；git add -A（所有变化文件）
* 提交至本地仓库：git commit -m "提交描述"
* 第一次提交至远程仓库：git push --set-upstream origin 分支名称
* 后续提交至远程仓库：git push -u origin 分支名称
