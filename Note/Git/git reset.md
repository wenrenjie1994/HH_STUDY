# git reset 

- 重置
- [具体逻辑](https://www.jianshu.com/p/c2ec5f06cf1a)

## 三种模式

- `--hard`：重置 HEAD 位置、工作区、暂存区、版本库，实际上是完全退回指定版本
- `--soft`：重置 HEAD 位置，保留工作区、暂存区，版本库和目标节点的差异放入**暂存区**
- `--mixed`：默认模式，可省略，重置位置、暂存区，保留工作区版本库和目标节点的差异放入**工作区**

### 使用

- `git reset --hard HEAD^`：退回上一个版本
- `git reset --hard HEAD^^`：退回上上个版本
- `git reset --hard HEAD~100`：退回上100个版本
- `git reset --hard HEAD commit散列值前7位`：退回到指定版本

### 巧用

- `git reset [--mixed] HEAD`：退回当前版本，可以用来清空暂存区
- `git reset [--mixed] HEAD helloWord.txt `：指定文件退回当前版本，可以用来清空指定文件在暂存区的变化