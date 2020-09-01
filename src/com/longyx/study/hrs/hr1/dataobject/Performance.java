package com.spdb.study.hrs.hr1.dataobject;

import lombok.Data;

import java.io.Serializable;

/**
 * 绩效实体类
 * @author Mr.Longyx
 * @date 2020年07月20日 22:18
 */
@Data
public class Performance implements Serializable {
    private static final long serialVersionUID = 4972048507216368709L;

    private float performance;

    private Employee employee;
    private ExamineType examineType;
}
