# git 

## 教程

- [官方教程](https://git-scm.com/book/zh/v2)
- [廖雪峰教程](https://www.liaoxuefeng.com/wiki/896043488029600)
- [菜鸟教程](https://www.runoob.com/git/git-tutorial.html)
- [git指令范围图](http://ndpsoftware.com/git-cheatsheet.html#loc=index;)
- [Git奇淫巧技](https://github.com/521xueweihan/git-tips)

## 概念

- 工作区：用户电脑可见的文件及目录
    - 通过 git add 将目录和文件添加到暂存区
- 暂存区：.git目录下的index文件中
    - 通过 git commit 将目录和文件添加到版本库
- 版本库：.git目录
- master：主分支
- HEAD：指向当前分支的指针

## 生成 SSH key

- `ssh-keygen -t rsa -C "用户邮箱"`：生成用户的 SSH Key
- 在 `C:\User\用户名\.ssh\id_rsa.pub` 中查看公钥