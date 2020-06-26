# git log

- 查看版本信息
- **使用可视化更好**

## 具体指令

### 无参数
- 查看所有信息
  - `git log`：查看所有信息

### --stat

- 仅显示增改行数统计
  - `git log --stat`

### -p

- 显示每次提交的内容差异
  - `git log -p -2`：仅显示最近两次提交的内容差异

### --pretty

- 指定格式展示提交历史
  - `git log --pretty=oneline`：查看简化版本信息
  - `git log --pretty=short`
  - `git log --pretty=full`
  - `git log --pretty=fuller`

###  --grapth

- 图形化的版本变化
  - `git log --graph`

### -<number>

- 只显示最近的 n 行
  - `git log -2`：只显示最近到的 2 行