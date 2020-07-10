# Git理解和常用命令

## 基础

类似与命令行的部分：

cd、mkdir等 命令都是一样的。

使用了git的命令相当于是在与远程库进行操作。origin在git中代指远程端。

![git-stage-after-commit](https://www.liaoxuefeng.com/files/attachments/919020100829536/0)

工作区：就是电脑上直接操作的目录。

版本库：使用init命令建立的.git文件就是git的版本库，与git的版本控制有关。其中的核心就是stage（或者index）的暂存区，在Git中暂存区用于暂时存放文件修改，直到使用commit或者push等命令时才会将修改执行到分支中（在创建版本库时会创建唯一master分支）。有点类似于数据库的事务，用于保证版本的一致性。

commit：将暂存区的内容修改到本地分支中。

push：对比本地分支和远程分支的记录，若本地分支的记录更新表示进行了修改，就将本地的东西push上去。

注意：三连：commit->pull->push（先commit提交到本地分支，然后pull，git会标记处与commit修改重合的地方，用于检查是否有覆盖类型的修改，最后push上传完成。）

## GIT部分：

git init ：git的初始化工作，标识某个文档是git文档，会在文件夹中创建.git文件。

### SSH

SSH -keygen -t -rsa -C “邮箱”：在本地创建SSH秘钥，需要将秘钥在github上新建SSH上传，内容在新建出来的id_rsa.pub（注意：需要去创建的文件夹中去找，可以手动找，也可以直接命令行cat id_rsa.pub来查看。）

### **添加远程库**
（github上新建git仓库,选择REAMDE.md）
git remote add origin git@github.com:TaylorApril/Baidu.git
git push -u origin master
（报错）
git pull --rebase origin master
git push -u origin master
git push origin master

### **提交

git add 文件名
（所有文件 git add .）
git commit -m "说明文字"
git push

### 版本回退

git log --prtty=oneline：查看最近到最远提交日志
git reset --hard HEAD^：回退版本计数：HEAD^上一个版本、HEAD~100上与100个版本
git reset --hard 3628df：回退版本号码：回退版本commit id为3628df
git reflog：想要恢复:使用命令记录来找回commit id回退

### 删除文件
rm 文件名：从版本库中删除
git rm 文件名：远程删除
git commit -m "delete"：操作备注
git checkout -- read.txt：删错了（是将工作区的内容回退到暂存区的状态，）

### 分支

创建分支：git branch 分支名
切换分支：git checkout 分支名
创建+切换分支：git checkout -b 分支名
查看当前分支：git branch
切换回master分支：git checkout master
合并指定分支到当前分支：git merge 分支名
(fast-forward 快进模式)
删除分支：git branch -d 分支名

### 解决冲突

(分支名字fea)

冲突原因：master和Dev同时增长。
git checkout -b fea
（修改Creating a new branch is quick AND simple.）
git add read.txt
git commit -m "fea"
git checkout master
（修改Creating a new branch is quick & simple.）
git addread.txt
git commit -m "master"
（此时形成了master和fea各自指着一个分支）
git merge fea
（合并错误，git status , cat read.txt可以查看）
（修改read.txt的文本内容 Creating a new branch is quick and simple.）
git add read.txt
git commit -m “conf”
（现在master和fea指向同一个人点了，git log可查看合并情况）
git branch -d fea

 

### 分支管理策略

（--no-ff）（分支名字dev 文件名字read.txt）

git checkout -b dev
git add read.txt
git commit -m "dev"
git checkout master
（注意下个参数--no-ff,表示禁用fast forward）
（fast forward合并看不出曾经做过合并，而--no-ff参数合并后的历史有分支，negative看出曾经做过合并）
git merge --no-ff -m "merge with --no-ff" dev
（查看分支历史 git log --graph --pretty=oneline --abbrev-commit）

 

### bug分支

(bug分支为要解决bug的分支)

思想：当手头还有工作时，先将工作现场git stash(避免bug修复好后将为完成的工作一起提交),然后修复bug、提交之后，在用git stash pop将原来的工作显示在工作区 。
（git status查看状态）
git stash
git checkout -b bugg
（修改bug后）
git add bugg.txt
git commit -m "fixed bug"
git checkout master
git merge --no-ff -m "merge bug" bugg
git branch -d bugg
（接下来回到dev上继续工作）
git checkout dev
（查看工作区git status）
（用git stash list查看）
git stash list
（恢复的第一种方法：恢复的同时把stash内容同时删除）
git stash pop
（恢复的第二种方法：恢复的同时不删除stash内容）
git stash apply
（若使用第二种方法想删除stash则用git stash drop）
（若是多个文件stash 可用git stash apply stash@{0}恢复指定的stash）

 


### feature分支(分支为dev)
（在没完全完成合并时强行删除）
git branch -D dev

 


### 多人协作
（查看远程库信息）
git remote
（查看远程库更详细信息）
git remote -v

推送dev分支
git push origin dev

抓取分支
（克隆）
git clone git@github.com:TaylorApril/test.git
（查看能见分支 git branch）
（在dev分支上开发，创建远程origin的dev分支到本地）
git checkout -b dev origin/dev
（修改后，进行提交）
git commit -m "add"
git push origin dev
（在他提交之后你再push的情况时）
（指定本地dev分支与远程origin分支链接）
git branch
git pull
git commit -m "fixed"
git push