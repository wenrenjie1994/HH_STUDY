# git config

- 作用：该命令主要用于编辑git的配置文件

## 配置文件级别
- `--local`：仓库级别，最高优先级，配置文件在仓库中
  - 路径：`仓库名/.git/config`
- `--global`：用户级别，优先度次之，在 Windows 用户目录下
  - 路径：`C:/User/用户名/.gitconfig`
- `--system`：系统级别，最低优先度，在 git 应用的安装目录下
  - 路径：`安装目录/Git/mingw64/etc/gitconfig`
  - 或者：`安装目录/Git/etc/gitconfig`

## 具体指令

### -l, --list

- 查看配置文件中的配置信息
  - `git config -l` 查看所有配置信息，包括系统、用户、仓库级别
  - `git config --global -l`  查看用户级别的所有配置信息

### -e, --edit

- 向配置文件中添加新的配置项，该指令可省略只保留配置项
  - `git config [--local|--global|--system] [--add] section.key value`
    - `[--local|--global|--system]` 省略后默认为 `local` 级别
    - `section`：？
    - `key`：表示键
    - `value`：表示值
- 举例
  - `git config --add cat.name tom`：向仓库级别的配置文件中国增加 `cat.name tom` 的配置项

### --get

- 获取指定的配置项信息
  - `git config [--local|--global|--system] --get section.key`
- 举例
    - `git config --get cat.name` ：获取 `cat.name` 的值

### --unset

- 删除指定配置项
    - `git config [--local|--global|--system] --unset section.key`
- 举例
    - `git config --unset cat.name tom` ：删除 `cat.name` 的值

## 应用

### 设置GUI

- `git config --global color.ui true`

### 设置用户

- `git config --global user.name "MartinVon"`：设置用户的昵称
- `git config --global user.email "985353348@qq.com"`：设置用户的邮箱

### 设置代理

- 加速 Git 的上传下载速度

#### 普通代理

- `git config --global https.proxy http://127.0.0.1:1080`
- `git config --global https.proxy https://127.0.0.1:1080`

#### SOCKS5 代理

- `git config --global http.proxy socks5://127.0.0.1:1080`
- `git config --global https.proxy socks5://127.0.0.1:1080`

#### 针对 GitHub 的 SOCKS5 代理

- `git config --global http.https://github.com.proxy socks5://127.0.0.1:1080`
- `git config --global https.https://github.com.proxy socks5://127.0.0.1:1080`

#### 取消代理

- 利用`--unset`指令删除配置项即可