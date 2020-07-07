package com.spdb.resume.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    private Integer id;

    private String name;

    private String idCardNumber;

    private String school;

    private String major;

    private Integer sex;

    private String email;

    private String phone;

    private Integer status;

    private Timestamp createTime;

    private Timestamp updateTime;
}