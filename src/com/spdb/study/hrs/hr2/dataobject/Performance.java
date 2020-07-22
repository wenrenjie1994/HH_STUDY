package com.spdb.study.hrs.hr2.dataobject;

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

    private int employeeId;
    private int examineTypeId;
    /**
     * 评估指标
     * @author Mr.Longyx
     */
    private String evaluationItems;
    /**
     * 绩效成绩
     * @author Mr.Longyx
     * @date 2020/7/22 11:24
     */
    private float grade;

    /**
     * 等级评定
     * @author Mr.Longyx
     * @date 2020/7/22 11:24
     */
    private String ratings;
}
