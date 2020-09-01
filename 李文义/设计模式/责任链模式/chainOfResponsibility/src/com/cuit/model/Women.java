package com.cuit.model;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Women implements IWomen {
    /*
     * 通过一个int类型的参数来描述妇女的个人状况
     * 1--未出嫁
     * 2--出嫁
     * 3--夫死
     */
    /**
     * 功能描述:
     * 通过一个int类型的参数来描述妇女的个人状况
     * 1--未出嫁
     * 2--出嫁
     * 3--夫死
     *
     * @author: liwenyi
     */
    private int type=0;
    /**
     * 功能描述:
     * 妇女的请示
     *
     * @author: liwenyi
     */
    private String request = "";
    /**
     * 功能描述:
     * 构造函数传递过来请求
     *
     * @param _type 1
     * @param _request 2
     * @return:
     * @author: liwenyi
     */
    public Women(int _type,String _request){
        this.type = _type;
        switch(this.type){
            case 1:
                this.request = "女儿的请求是：" + _request;
                break;
            case 2:
                this.request = "妻子的请求是：" + _request;
                break;
            case 3:
                this.request = "母亲的请求是：" + _request;
        }
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
}
