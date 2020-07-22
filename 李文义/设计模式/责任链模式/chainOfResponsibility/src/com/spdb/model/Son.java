package com.spdb.model;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Son extends Handler {
    /**
     * 功能描述:
     * 儿子只处理母亲的请求
     *
     * @return:
     * @author: liwenyi
     */
    public Son() {
        super(Handler.SON_LEVEL_REQUEST);
    }

    /**
     * 功能描述:
     * 儿子的答复
     *
     * @param women 1
     * @return: void
     * @author: liwenyi
     */
    @Override
    protected void response(IWomen women) {
        System.out.println("--------母亲向儿子请示-------");
        System.out.println(women.getRequest());
        System.out.println("儿子的答复是：同意\n");
    }
}
