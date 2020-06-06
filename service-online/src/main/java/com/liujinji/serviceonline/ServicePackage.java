package com.liujinji.serviceonline;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ServicePackage {
    @NotNull
    @Size(min = 4, message = "套餐名需大于4字符")
    private String name;
    @Size(min = 1, message = "至少选择一项内容")
    private List<String> serverItems;
}
