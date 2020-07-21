package com.spdb.study.hrs.hr1.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工实体类
 * @author Mr.Longyx
 * @date 2020年07月20日 21:48
 */
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 8543341888641076341L;

    private int employeeId;
    private int deptId;
    private String employeeName;
    private String gender;
    private String degree;
    private Date birthday;
    private String telephone;
    private String address;

    /**
     * 所属部门
     * @author Mr.Longyx
     * @date 2020/7/20 22:26
     */
    private Department department;
}
