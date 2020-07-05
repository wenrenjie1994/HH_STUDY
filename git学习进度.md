# 1、新建git仓库

## 1.1 本地操作

- 在工作目录中新建文件夹

  ```git
  $ mkdir testGit
  ```

- 进入该文件夹

  ```git
  $ cd testGit
  ```

- 将文件夹testGit初始化为git仓库

  ```git
  $ git init
  Initialized empty Git repository in E:/git/testGIT/.git/
  ```

## 1.2 推送到远程

1. 在GitHub上新建空仓库

2. 将本地仓库和远程仓库关联起来

   ```git
   $ git remote add origin git@github.com:(UserName)/(RepositoryName).git
   ```

3. 把本地库所有内容推送到远程库中

   ```git
   $ git push -u origin master
   ```



# 2、新建文件

- 新建空白文件并写入内容

  例如：

  ```test01.txt
  第一个测试txt文件。
  ```

  ```test02.txt
  第二个测试txt文件。
  ```

  ```test03.txt
  第三个测试txt文件。
  ```

- 添加文件。有几个需要提交的就添加几个。

  ```git
  $ git add test01.txt test02.txt test03.txt
  ```

- 提交

  ```git
  $ git commit -m "create three test txt files."
  [master (root-commit) 2af034a] create three test txt files.
   3 files changed, 3 insertions(+)
   create mode 100644 test01.txt
   create mode 100644 test02.txt
   create mode 100644 test03.txt
  ```
  
- 把当前分支的修改推送到远程

  ```git
  $ git push origin <branch_name>
  ```



# 3、修改文件

- 随意更改一个文件后保存

  例：在test01.txt中添加了一行：“增添的内容1。”

- 添加更改的文件

  ```git
  $ git add test01.txt
  ```

- 提交更改

  ```git
  $ git commit -m "add a line in test01.txt."
  [master ca86e59] add a line in test01.txt.
   1 file changed, 2 insertions(+), 1 deletion-)
  ```
  
- 把当前分支的修改推送到远程

  ```git
  $ git push origin <branch_name>
  ```



# 4、查看上次修改，但并未提交的内容

- 随便更改一个文件，并保存。

  例：在test02.txt文件中增添一行：“增添一行，使用git diff查看该版和上一版的差别。”

- 使用git diff命令查看修改内容。

  ```git
  $ git diff
  diff --git a/test02.txt b/test02.txt
  index 6231261..47ecf68 100644
  --- a/test02.txt
  +++ b/test02.txt
  @@ -1 +1,2 @@
  -第二个测试txt文件。
  \ No newline at end of file
  +第二个测试txt文件。
  +增添一行，使用git diff查看该版和上一版的差别。
  \ No newline at end of file
  ```



# 5、查看仓库的状态

```git
$ git status
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   test02.txt

no changes added to commit (use "git add" and/or "git commit -a")
```



# 6、切换某一版本

## 6.1 切换到上一版本（相对位置）

```git
/*回退到上一版 | 上上个版本 | ... | 往回100版*/
$ git reset --hard {HEAD^ | HEAD^^ | ... | HEAD~100}
```

## 6.2 切换到某一版本（绝对位置）

1. 查看提交日志中每次提交的版本号（commit后的就是版本号）

   ```git
   $ git log
   commit a78b5bc765df622d97dd01093c7955f8c355b27a (HEAD -> test1, origin/master, origin/liusiyuan, origin/HEAD, master, liusiyuan)
   Merge: 451d473 03f514b
   Author: tedadianfengshan <984254107@qq.com>
   Date:   Sat Jul 4 15:06:54 2020 +0800
   
       solve conflict
   
   commit 451d473d716807f59c230f370a0405078e850ce4
   Author: tedadianfengshan <984254107@qq.com>
   Date:   Sat Jul 4 15:03:38 2020 +0800
   
       test conflict
   
   commit 03f514bf9e3d67f4398225eeb2f55c75035a1a32
   Author: tedadianfengshan <62469299+tedadianfengshan@users.noreply.github.com>
   Date:   Sat Jul 4 15:00:28 2020 +0800
   
       Update test.java
   ```

2. 切换到指定版本

   ```git
   $ git reset --hard <commitNumber>
   ```



# 7、撤销操作

## 7.1 撤销暂存区的操作

```git
$ git reset HEAD <FileName>
```

​	PS：暂存区的操作被撤销后，该操作被退至工作区。

## 7.2 撤销工作区的操作

```git
$ git checkout -- <FileName>
```



# 8、操作分支

## 8.1 本地操作

1. 新建分支

   ```git
   /*新建分支*/
   $ git branch <branch_name>
   /*新建分支并切换到新分支，方法1（推荐）*/
   $ git switch -c <branch_name>
   /*新建分支并切换到新分支，方法2（不推荐）*/
   $ git checkout -b <branch_name>
   ```

2. 切换分支

   ```git
   /*方法1（推荐）*/
   $ git switch <branch_name>
   /*方法2（不推荐）*/
   $ git checkout <branch_name>
   ```

3. 删除分支

   ```git
   $ git branch -d <branch_name>
   ```

## 8.2 远程操作

1. 新建分支

   ```git
   $ git push origin <LocalBranchName>:<RemoteBranchName>
   ```

2. 删除分支

   ```git
   /*（方法1）实际是向远程仓库推送了一个空分支，起到删除的作用*/
   $ git push origin :<RemoteBranchName>
   /*（方法2）*/
   $ git push origin --delete <RemoteBranchName>
   ```

   