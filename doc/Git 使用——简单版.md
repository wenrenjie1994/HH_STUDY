## 使用 GIthub 的网络问题

### 科学上网

### 使用镜像

* https://github.com.cnpmjs.org/

  如命令 `git clone https://github.com/wenrenjie1994/HH_STUDY.git` 可以用 `git clone https://github.com.cnpmjs.org/wenrenjie1994/HH_STUDY.git`

### 改 DNS

### 骚操作

使用 Gitee 等将 Github 的仓库同步过来，然后通过 Gitee 等提供的链接 clone 仓库。

## 配置

全局配置：

```bash
git config --global user.name "在 Github 等站的名字或昵称"
git config --global user.email "在 Github 等站注册使用的邮箱"
# example
git config --global user.name "xiaoming"
git config --global user.email "xiaoming@163.com"
```

项目根目录下对单个项目进行配置：

```bash
git config user.name "在 Github 等站的名字或昵称"
git config user.email "在 Github 等站注册使用的邮箱"
```

## 一般流程

```bash
# 初始化项目文件夹为 Git 仓库（本地仓库）
git init
# 将本地仓库与远程仓库连接
git remote add [远程仓库在本地的名字] [远程仓库链接]
# example
git remote add origin git@github.com:wenrenjie1994/HH_STUDY.git
# 使用 git clone 时，Git 会为文件夹自动进行这一步，建立本地仓库与远程仓库的连接。
```



注意，远程仓库链接有两种：

* git@github.com:wenrenjie1994/HH_STUDY.git
* https://github.com/wenrenjie1994/HH_STUDY.git



若连接本地仓库与远程仓库时，使用的是 git 前缀的链接。在将本地仓库中的数据推向远程分支时，进行**权限验证** （判断你有没有操作远程仓库的权限），会要求配置「SSH」公钥。

若使用 HTTPS 链接，进行相应操作时会让输入帐号和密码。



建立链接后，将远程仓库的数据拉（pull）下来。

## SSH 配置

### 为什么要配置 SSH 公钥[#](https://wiki.leay.net/tech/config/git/2018-02-01-git/#ssh)

配置 SSH 公钥后，本地仓库与远程仓库可以通过 SSH 链接进行交互（pull，push 等操作）。

> SSH 链接示例： `git@github.com:wenrenjie1994/HH_STUDY.git`

反过来说，如果你通过 SSH 链接关联远程仓库与本地仓库，就必须配置 SSH 公钥，才能进行 Git 操作。

另一方面，如果你通过 HTTPS 链接进行关联，你就无需配置 SSH 公钥。

> HTTPS 链接示例：`https://github.com/wenrenjie1994/HH_STUDY.git`

若你通过 HTTPS 链接对本地仓库和远程仓库进行关联，在进行 push 操作时，Git 将会提示你手动输入密码以验证权限。

所以通过 SSH 与 HTTPS 链接关联远程仓库库与本地仓库的区别就显而易见了，通过 SSH 链接，一次配置后以后就无须重复输入密码，同时，不必输入密码，也在一定程度上保证了安全。

### 生成公钥[#](https://wiki.leay.net/tech/config/git/2018-02-01-git/#_6)

> ```
> ssh-keygen -t rsa -C "xxxxx@xxxxx.com（你的邮箱）"
> ```
>
> 连续按三次回车，使用默认配置即可

### 查询公钥[#](https://wiki.leay.net/tech/config/git/2018-02-01-git/#_7)

> ```
> cat ~/.ssh/id_rsa.pub
> ```

这一步是查询公钥，把显示的东西全复制下来即可。

如果操作系统是 Windows，可以打开 `C:\用户\Users\.ssh\id_rsa.pub` 文件查看公钥。

### 配置[#](https://wiki.leay.net/tech/config/git/2018-02-01-git/#_8)

然后把公钥粘贴到 Github 这类网站配置 SSH 公钥的的对应位置即可。

## 本地开发

// 新建分支

```
git branch add hengqingwen9707
```

// 切换到该分支

```
git checkout hengqingwen9707
```

开发

本地 推（push）到 远程

`git push origin<remote> hengqingwen9707<本地分支名>`

这样会把本地分支里的内容推到远程仓库里的同名分支，如果远程还没有这个分支就会新建。

## 基本操作

* git clone

  git clone https://github.com/wenrenjie1994/HH_STUDY.git<仓库名>

* git pull

  git pull orign<remote> master<branchName>

* git push

  git push origin<remote> heng<branchName>

**PS：了解下 rmeote 概念就行了。**

* git merge

  git merge <想要合并到当前分支的分支名>

### 其它

* git init
* git remote
* git branch

### 提交

* git add .
* git commit -m""
* git push