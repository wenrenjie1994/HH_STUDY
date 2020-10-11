package com.longyx.study.hrs.hr2.dataobject;

import java.io.Serializable;

/**
 * 部门实体类
 * @author Mr.Longyx
 * @date 2020年07月20日 22:03
 */

public class Department implements Serializable {
    private static final long serialVersionUID = -7605999156709087747L;

    private int departmentId;
    private int pid;
    private String departmentName;
    private int leaf;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getLeaf() {
        return leaf;
    }

    public void setLeaf(int leaf) {
        this.leaf = leaf;
    }
}
