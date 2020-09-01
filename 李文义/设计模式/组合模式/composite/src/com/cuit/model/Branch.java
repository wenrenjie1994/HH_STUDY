package com.cuit.model;

import java.util.ArrayList;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Branch extends Corp {
    /**
     * 功能描述:
     * 领导下边有哪些下级领导和小兵
     *
     * @author: liwenyi
     */
    ArrayList<Corp> subordinateList = new ArrayList<Corp>();

    public Branch(String _name, String _position, int _salary) {
        super(_name, _position, _salary);
    }

    /**
     * 功能描述:
     * 增加一个下属，可能是小头目，也可能是个小兵
     *
     * @return: void
     * @author: liwenyi
     */
    public void addSubordinate(Corp corp) {
        this.subordinateList.add(corp);
    }

    /**
     * 功能描述:
     * 我有哪些下属
     *
     * @return: java.util.ArrayList<com.cuit.model.Corp>
     * @author: liwenyi
     */
    public ArrayList<Corp> getSubordinate() {
        return this.subordinateList;
    }
}
