Git Learning 

1. 从远程库克隆

   GitHub给出的地址不止一个，可用 ：git clone git@github.com:accountername/repository name .git (速度最快)

   或者：git https://github.com/accountname/repositoryname .git  (速度慢)

2. 分支管理

   - 创建分支：git branch <name>
   - 查看分支：git branch 

   - 创建并切换分支：git checkout -b `branchname`      或    git switch -c `branchname`
   - 切换分支：git checkout `branchname`         或  git switch `branchname`
   - 合并分支：git checkout master            git merge `branchname`  
   - 删除分支：git branch -d `branchname` 