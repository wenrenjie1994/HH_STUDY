package com.spdb.study.design.pattern.mediator.match;

/**
 * 中介类
 * @author Mr.Longyx
 * @date 2020年07月12日 15:54
 */
public class Meditor {
    private Boy boy;
    private Girl girl;

    public void setBoy(Boy boy) {
        this.boy = boy;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public Boy getBoy() {
        return boy;
    }

    public Girl getGirl() {
        return girl;
    }

    public void findTheHalf(Colleague colleague){
        if (colleague instanceof Boy){
            this.setBoy((Boy) colleague);
        }else {
            this.setGirl((Girl) colleague);
        }
        if (isMatched(colleague)){
            System.out.println(boy.getName()+"和"+girl.getName()+"配对成功");
        }else {
            System.out.println(boy.getName()+"和"+girl.getName()+"配对失败");
        }
    }

    private boolean isMatched(Colleague colleague) {
        if (colleague.getMeditor().getBoy().getCondition() == colleague.getMeditor().getGirl().getCondition()){
            return true;
        }else {
            return false;
        }
    }
}
