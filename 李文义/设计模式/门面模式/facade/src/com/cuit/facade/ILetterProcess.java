package com.cuit.facade;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public interface ILetterProcess {
    /**
     * 功能描述:
     * 首先要写信的内容
     *
     * @param context 1
     * @return: void
     * @author: liwenyi
     */
    public void writeContext(String context);

    /**
     * 功能描述:
     * 其次写信封
     *
     * @param address 1
     * @return: void
     * @author: liwenyi
     */
    public void fillEnvelope(String address);

    /**
     * 功能描述:
     * 把信放到信封里
     *
     * @return: void
     * @author: liwenyi
     */
    public void letterInotoEnvelope();

    /**
     * 功能描述:
     * 然后邮递
     *
     * @return: void
     * @author: liwenyi
     */
    public void sendLetter();
}
