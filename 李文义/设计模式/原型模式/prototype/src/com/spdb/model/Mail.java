package com.spdb.model;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Mail implements Cloneable{
    /**
     * 功能描述:
     * 收件人
     *
     * @author: liwenyi
     */
    private String receiver;
    /**
     * 功能描述:
     * 邮件名称
     *
     * @author: liwenyi
     */
    private String subject;
    /**
     * 功能描述:
     * 称谓
     *
     * @author: liwenyi
     */
    private String appellation;
    /**
     * 功能描述:
     * 邮件内容
     *
     * @author: liwenyi
     */
    private String context;
    /**
     * 功能描述:
     * 邮件尾部
     *
     * @author: liwenyi
     */
    private String tail;
    /**
     * 功能描述:
     * 构造函数
     *
     * @param advTemplate 1
     * @return:
     * @author: liwenyi
     */
    public Mail(AdvTemplate advTemplate){
        this.context = advTemplate.getAdvContext();
        this.subject = advTemplate.getAdvSubject();
    }

    @Override
    public Mail clone(){
        Mail mail =null;
        try {
            mail = (Mail)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mail;
    }

    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getAppellation() {
        return appellation;
    }
    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public String getTail() {
        return tail;
    }
    public void setTail(String tail) {
        this.tail = tail;
    }
}
