package com.liujinji.serviceonline;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Student {
    @NotBlank(message = "ID不能为空！")
    private String stuID;

    @NotBlank(message = "姓名不能为空！")
    private String stuName;
}
