# git

## 存储方式

git会把内容按**元数据**方式存储，类似于K-V数据库

通过git cat-file -p命令来查看指定key的文件内容（value），类型为blob的key（8035d16db17375c987f167ee00331b921f888019）的内容为“新员工学习计划...”，key值是通过value的hash计算得来。

![](images\catfile.png)

通过git cat-file -t查看指定key的类型

![](images\type.png)

发现指定key为blob对象。

blob（binary large object)，表示二进制大对象，Blob通常表示二进制数据，不过它们不一定非得是大量数据，Blob也可以表示一个小型文本文件的内容。

原理示意图

![](images\image-20191203162120940.png)

本地仓库的优势在于，远程仓库服务器挂掉以后依然能够存储在本地仓库



## 文件状态

**工作目录中的每一个文件**都有两个状态：未跟踪和已跟踪。已跟踪的文件是那些被纳入版面控制的文件，在上一次的快照中有他们的记录，在工作一段时间后，他们可能处于unmodified、modified、staged，未跟踪的文件既不存在上次的快照记录，也没有存入暂存区。初始化一个仓库后，所有的文件都处于未修改状态。

![](images\image-20191209141635967.png)



## 常用命令

git cat-file -p查看指定key文件的内容

git --version查看git版本

git config -l查看配置信息

git status查看本地仓库状态

git add -A提交所有文件至暂存区

git remote -v查看远程仓库状态

![](images\two.png)

两个进程（fetch抓取进程，push上传进程）

git remote add origin <远程仓库地址>添加远程仓库地址（名称一般为origin）

git push --set-upstream origin XXX 与远程origin的XXX分支建立联系

git diff  XX1 master 查看xx1与master分支的差别