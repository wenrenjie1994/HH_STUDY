package com.cuit.memento;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Memento {
    /**
     * 功能描述:
     * 男孩的状态
     *
     * @param null 1
     * @return:
     * @author: liwenyi
     */
    private String state = "";

    public Memento(String _state){
        this.state = _state;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
