package com.longyx.study.design.pattern.chain.auth.optimizer;

import com.longyx.study.design.pattern.chain.auth.old.User;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Mr.Longyx
 * @date 2020年07月10日 21:48
 */
public class ValidateHandler extends Handler {
    @Override
    public void doHandler(User user) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
            System.out.println("用户名或密码不能为空");
            return;
        }
        System.out.println("用户名和密码正确，可以往下执行");
        this.next.doHandler(user);
    }
}
