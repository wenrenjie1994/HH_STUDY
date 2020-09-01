package com.spdb.study.design.pattern.adapter.loginadapter.v2;

import com.spdb.study.design.pattern.adapter.loginadapter.ResultMsg;
import com.spdb.study.design.pattern.adapter.loginadapter.v1.service.SiginService;
import com.spdb.study.design.pattern.adapter.loginadapter.v2.adapters.*;

/**
 * 结合策略模式+工厂模式+适配器模式实现可以兼容多平台登陆的业务场景
 * @author Mr.Longyx
 * @date 2020年07月02日 16:45
 */
public class PassportForThirdAdapter extends SiginService implements PassportForThird {

    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id,QQLoginAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return processLogin(id,WeChatLoginAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, TokenLoginAdapter.class);
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return processLogin(telphone, TelephoneLoginAdapter.class);
    }

    @Override
    public ResultMsg loginForSina(String id) {
        return processLogin(id,SinaLoginAdapter.class);
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        super.regist(username,passport);
        return super.login(username,passport);
    }

    /**
     * 判断传过来的适配器是否能够处理对应的逻辑
     * @author Mr.Longyx
     * @date 2020/7/2 17:33
     * @param key
     * @param clazz
     * @return com.spdb.study.design.pattern.adapter.loginadapter.ResultMsg
     */
    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz){
        try {
            //此处适配器不一定得实现接口
            LoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)){
                adapter.login(key,adapter);
            }else {
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
