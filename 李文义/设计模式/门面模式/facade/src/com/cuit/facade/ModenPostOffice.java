package com.cuit.facade;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class ModenPostOffice {
    private ILetterProcess letterProcess = new LetterProcessImpl();
    private Police letterPolice = new Police();
    /**
     * 功能描述:
     * 写信，封装，投递，一体化
     *
     * @param context 1
     * @param address 2
     * @return: void
     * @author: liwenyi
     */
    public void sendLetter(String context, String address) {
        //帮你写信
        letterProcess.writeContext(context);
        //写好信封
        letterProcess.fillEnvelope(address);
        //警察要检查信件了
        letterPolice.checkLetter(letterProcess);
        //把信放到信封中
        letterProcess.letterInotoEnvelope();
        //邮递信件
        letterProcess.sendLetter();
    }
}
