package com.spdb.memento;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Boy {
    /**
     * 功能描述:
     * 男孩的状态
     *
     * @author: liwenyi
     */
    private String state = "";

    /**
     * 功能描述:
     * 认识女孩子后状态肯定改变，比如心情、手中的花等
     *
     * @return: void
     * @author: liwenyi
     */
    public void changeState() {
        this.state = "心情可能很不好";
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * 功能描述:
     * 保留一个备份
     *
     * @return: Memento
     * @author: liwenyi
     */
    public Memento createMemento() {
        return new Memento(this.state);
    }

    /**
     * 功能描述:
     * 恢复一个备份
     *
     * @param _memento 1
     * @return: void
     * @author: liwenyi
     */
    public void restoreMemento(Memento _memento) {
        this.setState(_memento.getState());
    }
}
