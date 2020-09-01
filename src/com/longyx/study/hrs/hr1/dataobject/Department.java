package com.spdb.study.hrs.hr1.dataobject;

import lombok.Data;

import java.io.Serializable;

/**
 * 部门实体类
 * @author Mr.Longyx
 * @date 2020年07月20日 22:03
 */
@Data
public class Department implements Serializable {
    private static final long serialVersionUID = -7605999156709087747L;

    private int departmentId;
    private int pid;
    private String departmentName;
    private int leaf;
}
