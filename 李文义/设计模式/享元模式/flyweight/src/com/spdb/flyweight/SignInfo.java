package com.spdb.flyweight;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class SignInfo {
    /**
     * 功能描述:
     * 报名人员的ID
     *
     * @author: liwenyi
     */
    private String id;
    /**
     * 功能描述:
     * 考试地点
     *
     * @author: liwenyi
     */
    private String location;
    /**
     * 功能描述:
     * 考试科目
     *
     * @author: liwenyi
     */
    private String subject;
    /**
     * 功能描述:
     * 邮寄地址
     *
     * @author: liwenyi
     */
    private String postAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }
}
