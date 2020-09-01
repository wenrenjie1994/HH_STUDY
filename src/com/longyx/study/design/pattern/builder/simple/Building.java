package com.spdb.study.design.pattern.builder.simple;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  房屋建造过程抽象
 * @author Mr.Longyx
 * @date 2020年07月05日 9:46
 */
public class Building implements Serializable {

    private static final long serialVersionUID = 5859590884618708658L;

    /**
     * 用于模拟建造房子过程中各种组件的堆叠
     * @author Mr.Longyx
     * @date 2020/7/5 9:49
     */
    List<String> components = new ArrayList<>();

    public void setBasement(String basement){
        this.components.add(basement);
    }

    public void setWall(String wall){
        this.components.add(wall);
    }


    public void setRoof(String roof){
        this.components.add(roof);
    }

    /**
     * 将建造过程中各个组件拼接组成完整的房子
     * @author Mr.Longyx
     * @date 2020/7/5 9:53
     */
    @Override
    public String toString() {
        String str = "";
        for(int i=components.size()-1;i>0;--i){
            str += components.get(i);
        }
        return str;
    }
}
