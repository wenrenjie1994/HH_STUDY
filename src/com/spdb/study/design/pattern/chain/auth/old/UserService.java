package com.spdb.study.design.pattern.chain.auth.old;

import org.apache.commons.lang3.StringUtils;

/**
 * 待优化的实现
 * @author Mr.Longyx
 * @date 2020年07月10日 20:42
 */
public class UserService {
    public void login(String username, String password){
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            System.out.println("用户名或密码不能为空");
            return;
        }
        System.out.println("用户名和密码正确，可以往下执行");

        User user = checkExists(username,password);
        if (null == user){
            System.out.println("该用户不存在！");
            return;
        }
        System.out.println("登录成功！");

        if (!"管理员".equals(user.getRoleName())){
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("允许进一步操作");
    }

    private User checkExists(String username, String password) {
        User user = new User(username,password);
        user.setRoleName("管理员");
        return user;
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.login("cafebabe","hadoop");
    }

}
