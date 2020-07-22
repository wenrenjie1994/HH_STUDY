package com.spdb.study.hrs.hr2.dataobject;

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
    private int departmentId;
    private String employeeName;
    private String gender;
    private String degree;
    private Date birthday;
    private String telephone;
    private String address;
    /**
     * 职位
     * @author Mr.Longyx
     * @date 2020/7/22 11:20
     */
    private String position;
    /**
     * 所属分公司
     * @author Mr.Longyx
     * @date 2020/7/22 11:19
     */
    private String division;
    /**
     * 入职日期
     * @author Mr.Longyx
     * @date 2020/7/22 11:20
     */
    private Date dateJoined;

}
