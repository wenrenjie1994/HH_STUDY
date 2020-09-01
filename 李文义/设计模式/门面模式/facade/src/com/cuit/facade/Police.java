package com.cuit.facade;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Police {
    /**
     * 功能描述:
     * 检查信件，检查完毕后警察在信封上盖个戳：此信无病毒
     *
     * @param letterProcess 1
     * @return: void
     * @author: liwenyi
     */
    public void checkLetter(ILetterProcess letterProcess){
        System.out.println(letterProcess+" 信件已经检查过了...");
    }
}
