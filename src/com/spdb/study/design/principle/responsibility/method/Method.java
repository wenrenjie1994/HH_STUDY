package com.spdb.study.design.principle.responsibility.method;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 14:41
 */
public class Method {
    /**
     * 以下方法不符合方法的单一职责原则
     * @author Mr.Longyx
     * @date 2020/6/17 14:44
     * @param userName
     * @param address
     */
    private void updateUserInfo(String userName, String address){
        userName = "龙远栩";
        address = "chengdu";
    }

    private void updateUserInfo(String userName,String ... fields){

    }

    /**
     * 以下方法满足单一职责原则
     * @author Mr.Longyx
     * @date 2020/6/17 14:45
     */
    public void updateUserName(String userName){

    }

    public void updateUserAddress(String address){

    }

}
