package com.spdb.user;

import java.util.Map;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public interface IOuterUser {
    /**
     * 功能描述:
     * 基本信息，比如名称、性别、手机号码等
     *
     * @return: Map
     * @author: liwenyi
     */
    public Map getUserBaseInfo();

    /**
     * 功能描述:
     * 工作区域信息
     *
     * @return: Map
     * @author: liwenyi
     */
    public Map getUserOfficeInfo();

    /**
     * 功能描述:
     * 用户的家庭信息
     *
     * @return: Map
     * @author: liwenyi
     */
    public Map getUserHomeInfo();
}
