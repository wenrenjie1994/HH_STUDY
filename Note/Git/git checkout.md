# git checkout

- 与分支相关

## 固体指令

### 无参数

- `git checkout .`：未使用 `git add` 时，使用该语句放弃所有**工作区**修改
- `git checkout --<fileName>`：同上，指定文件

### <branchName>

- 切换到指定分支
  - `git checkout master`：切换到 master 分支

### -b <branchName>

- 创建并切换到新分支
  
  - `git checkout -b beta`：创建并切换到 beta 分支
- 等价于
  - ```shell
    git branch branchName
    git checkout branchName
    ```