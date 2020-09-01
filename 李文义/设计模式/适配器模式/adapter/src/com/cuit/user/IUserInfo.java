package com.cuit.user;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public interface IUserInfo {
    /**
     * 功能描述:
     * 获得用户姓名
     *
     * @return: java.lang.String
     * @author: liwenyi
     */
    public String getUserName();

    /**
     * 功能描述:
     * 获得家庭地址
     *
     * @return: java.lang.String
     * @author: liwenyi
     */
    public String getHomeAddress();

    /**
     * 功能描述:
     * 手机号码，这个太重要，手机泛滥呀
     *
     * @return: java.lang.String
     * @author: liwenyi
     */
    public String getMobileNumber();

    /**
     * 功能描述:
     * 办公电话，一般是座机
     *
     * @return: java.lang.String
     * @author: liwenyi
     */
    public String getOfficeTelNumber();

    /**
     * 功能描述:
     * 这个人的职位是什么
     *
     * @return: java.lang.String
     * @author: liwenyi
     */
    public String getJobPosition();

    /**
     * 功能描述:
     * 获得家庭电话，这有点不好，我不喜欢打家庭电话讨论工作
     *
     * @return: java.lang.String
     * @author: liwenyi
     */
    public String getHomeTelNumber();
}
