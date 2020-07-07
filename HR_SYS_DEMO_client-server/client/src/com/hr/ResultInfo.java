package com.hr;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultInfo implements Serializable {
    private static final long serialVersionUID = 2222;
    private int flag = 1;
    private List<Resume> resultList = null;
    public ResultInfo(int flag){
        this.flag = flag;
    }
    public ResultInfo(List resultList){
        this.resultList = resultList;
    }
    public int getFlag(){
        return this.flag;
    }
    public List getResultList(){
        return this.resultList;
    }
}
