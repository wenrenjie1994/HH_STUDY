package com.spdb.model;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Father extends Handler{
    /**
     * 功能描述:
     * 父亲只处理女儿的请求
     *
     * @return:
     * @author: liwenyi
     */
    public Father(){
        super(Handler.FATHER_LEVEL_REQUEST);
    }
    /**
     * 功能描述:
     * 父亲的答复
     *
     * @param women 1
     * @return: void
     * @author: liwenyi
     */
    @Override
    protected void response(IWomen women) {
        System.out.println("--------女儿向父亲请示-------");
        System.out.println(women.getRequest());
        System.out.println("父亲的答复是:同意\n");
    }
}
