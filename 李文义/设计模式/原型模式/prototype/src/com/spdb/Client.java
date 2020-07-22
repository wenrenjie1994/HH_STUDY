package com.spdb;

import com.spdb.model.AdvTemplate;
import com.spdb.model.Mail;

import java.util.Random;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Client {
    /**
     * 功能描述:
     * 发送账单的数量，这个值是从数据库中获得
     *
     * @return:
     * @author: liwenyi
     */
    private static int MAX_COUNT = 6;
    public static void main(String[] args) {
        //模拟发送邮件
        int i = 0;
        //把模板定义出来，这个是从数据库中获得
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("XX银行版权所有");
        while (i < MAX_COUNT) {
            //以下是每封邮件不同的地方
            Mail cloneMail = mail.clone();
            cloneMail.setAppellation(getRandString(5) + " 先生（女士）");
            cloneMail.setReceiver(getRandString(5) + "@" + getRandString(8) + ".com");
            //然后发送邮件
            sendMail(cloneMail);
            i++;
        }
    }

    //发送邮件
    public static void sendMail(Mail mail) {
        System.out.println("标题：" + mail.getSubject() +
                "\t收件人： "+mail.getReceiver()+
                "\t内容： "+mail.getContext()+
                "\t称谓： "+mail.getAppellation()+
                "\t尾部： "+mail.getTail()+
                "\t...发送成功！");
    }

    /**
     * 功能描述:
     * 获得指定长度的随机字符串
     *
     * @param maxLength 1
     * @return: java.lang.String
     * @author: liwenyi
     */
    public static String getRandString(int maxLength) {
        String source = "abcdefghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random rand = new Random();
        for (int i = 0; i < maxLength; i++) {
            sb.append(source.charAt(rand.nextInt(source.length())));
        }
        return sb.toString();
    }
}
