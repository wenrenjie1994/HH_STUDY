package com.spdb.flyweight;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class SignInfo4Pool extends SignInfo {
    /**
     * 功能描述:
     * 定义一个对象池提取的KEY值
     *
     * @author: liwenyi
     */
    private String key;

    public SignInfo4Pool(String _key) {
        this.key = _key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
