# git stash

- 保存当前工作现场，然后切换到其他现场

## 具体指令

### 无参数

- `git stash`：保存当前所有为提交的修改，包括工作区和暂存区，自动命名

### save

- 提供注释
  - `git stash save stash1`：将当前保存注释为 stash1

### list

- 查看当前 stash 中的内容

### apply

- 恢复工作现场

### drop 

- 删除工作现场

### pop

- 恢复并删除工作现场
- 等价于 `apply` + `drop`