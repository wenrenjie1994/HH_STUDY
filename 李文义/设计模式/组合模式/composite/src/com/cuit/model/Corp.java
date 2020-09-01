package com.cuit.model;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public abstract class Corp {
    /**
     * 功能描述:
     * 公司每个人都有名称
     *
     * @author: liwenyi
     */
    private String name = "";
    /**
     * 功能描述:
     * 公司每个人都职位
     *
     * @author: liwenyi
     */
    private String position = "";
    /**
     * 功能描述:
     * 公司每个人都有薪水
     *
     * @author: liwenyi
     */
    private int salary =0;

    public Corp(String _name,String _position,int _salary){
        this.name = _name;
        this.position = _position;
        this.salary = _salary;
    }
    /**
     * 功能描述:
     * 获得员工信息
     *
     * @return: java.lang.String
     * @author: liwenyi
     */
    public String getInfo(){
        String info = "";
        info = "姓名：" + this.name;
        info = info + "\t职位："+ this.position;
        info = info + "\t薪水：" + this.salary;
        return info;
    }
}
