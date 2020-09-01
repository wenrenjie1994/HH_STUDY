package com.cuit.model;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Husband extends Handler {
    /**
     * 功能描述:
     * 丈夫只处理妻子的请求
     *
     * @return:
     * @author: liwenyi
     */
    public Husband() {
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }

    /**
     * 功能描述:
     * 丈夫请示的答复
     *
     * @return: void
     * @author: liwenyi
     */
    @Override
    protected void response(IWomen women) {
        System.out.println("--------妻子向丈夫请示-------");
        System.out.println(women.getRequest());
        System.out.println("丈夫的答复是：同意\n");
    }
}
