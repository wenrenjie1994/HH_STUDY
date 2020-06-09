package com.liujinji.serviceonline;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Data
public class Order {
    @NotBlank(message = "姓名不能为空！")
    private String name;

    @NotBlank(message = "省份不能为空！")
    private String province;

    @NotBlank(message = "城市不能为空！")
    private String city;

    @NotBlank(message = "详细地址不能为空！")
    private String address;

    @CreditCardNumber(message = "错误的信用卡号")
    private String ccNumber;

    @NotBlank(message = "有效日期不能为空！")
    private String ccExpiration;

    @Digits(integer = 3,fraction = 0,message = "请输入3位CVV")
    private String ccCVV;
}
