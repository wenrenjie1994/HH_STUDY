package com.cuit.flyweight;

import java.util.HashMap;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class SignInfoFactory {

    /**
     * 功能描述:
     * 池容器
     *
     * @author: liwenyi
     */
    private static HashMap<String, SignInfo> pool = new HashMap<String, SignInfo>();

    /**
     * 功能描述:
     * 报名信息的对象工厂
     *
     * @return:
     * @author: liwenyi
     */
    @Deprecated
    public static SignInfo SignInfo() {
        return new SignInfo();
    }

    /**
     * 功能描述:
     * 从池中获得对象
     *
     * @return: com.cuit.flyweight.SignInfo
     * @author: liwenyi
     */
    public static SignInfo getSignInfo(String key) {
        //设置返回对象
        SignInfo result = null;
        //池中没有该对象，则建立，并放入池中
        if (!pool.containsKey(key)) {
            System.out.println(key + "----建立对象，并放置到池中");
            result = new SignInfo4Pool(key);
            pool.put(key, result);
        } else {
            result = pool.get(key);
            System.out.println(key + "---直接从池中取得");
        }
        return result;
    }
}
